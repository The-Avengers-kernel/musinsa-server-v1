package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.repository.ProductRepository;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    // 의존성 주입
    private final ProductRepository productRepository;

    public ProductDetailResponse getProductById(Long productId) {
        ProductDetailResponse productInfo = productRepository.findProductById(productId);
        List<ProductImage> productImage = productRepository.findProductImageById(productId);
        productInfo.getProductImageList().addAll(productImage);
        return productInfo;
    }

    public ProductVariantsResponse getProductVariants(Long productId) {
        List<String> colors = productRepository.findProductOptionColors(productId);
        List<String> materials = productRepository.findProductOptionMaterials(productId);
        List<String> sizes = productRepository.findProductOptionSizes(productId);

        return ProductVariantsResponse.builder()
                .productOptionColor(colors)
                .productOptionMaterial(materials)
                .productOptionSize(sizes)
                .build();
    }


    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productRepository.getRecommendationProductList(gender);
    }

    public Map<Long, List<ProductsInCartInfoResponse.OptionGroup>> getGroupsByProductIds(List<Long> productIds) {
        // 상품 ID 검증
        if (productIds == null || productIds.isEmpty()) {
            return Map.of();
        }

        // 각 상품들의 옵션 가져오기
        List<ProductOptionRow> productOptionRows = productRepository.findOptionRowsByProductId(productIds);

        // Map<상품ID, Map<optionType, OptionGroupBuilder(옵션종류, 옵션종류에 대한 값들) >>
        Map<Long, Map<String, OptionGroupBuilder>> optionOfProducts = new HashMap<>();

        // 상품에 대한 옵션 순회
        for (ProductOptionRow productOptionRow : productOptionRows) {
            Long productId = productOptionRow.getProductId(); // 상품ID
            String optionType = productOptionRow.getOptionType();
            // productId에 대한 옵션 정보 가져오기
            Map<String, OptionGroupBuilder> groupMap = optionOfProducts.get(productId);
            // 없으면 optionOfProducts Map 생성 후 put
            if (groupMap == null) {
                groupMap = new HashMap<>();
                optionOfProducts.put(productId, groupMap);
            }

            // groupId에 대한 옵션 정보 빌더 가져오기
            OptionGroupBuilder builder = groupMap.get(optionType);
            // 없으면 groupMap 생성 후 put
            if (builder == null) {
                builder = new OptionGroupBuilder(productOptionRow.getOptionType());
                groupMap.put(optionType, builder);
            }

            // 한 상품에 대해 옵션에 대한 값 추가
            builder.addValue(productOptionRow.getValue());
        }

        // productId -> List<OptionGroup>
        Map<Long, List<ProductsInCartInfoResponse.OptionGroup>> result = new HashMap<>();

        for (Map.Entry<Long, Map<String, OptionGroupBuilder>> entry : optionOfProducts.entrySet()) {
            List<ProductsInCartInfoResponse.OptionGroup> groups = new ArrayList<>();
            for (OptionGroupBuilder builder : entry.getValue().values()) {
                groups.add(builder.build());
            }
            result.put(entry.getKey(), groups);
        }
        return result;
    }
    // 상품상세 사이즈 리스트 조회
    public List<ProductDetailSizeList> getProductDetailSizeList(Long productId) {
    return productRepository.getProductDetailSizeList(productId);
    }

    // 내부 전용 빌더: 중복 제거 + 입력 순서 보존
    private static class OptionGroupBuilder {
        private final String optionType;
        private final LinkedHashSet<String> values = new LinkedHashSet<>();

        OptionGroupBuilder(String name) {
            this.optionType = name;
        }

        // 옵션에 대한 값 추가
        // ex) color라면 add("green"), add("blue"), ... 등등
        void addValue(String value) {
            if (value != null) {
                values.add(value);
            }
        }

        ProductsInCartInfoResponse.OptionGroup build() {
            return new ProductsInCartInfoResponse.OptionGroup(
                    optionType, List.copyOf(values)
            );
        }
    }

    public List<ProductByCategoryResponse> getProductsByCategory(Long categoryId) {
        log.info("카테고리 ID로 상품 조회 시작: {}", categoryId);

        List<ProductByCategoryResponse> result = productRepository.getProductsByCategory(categoryId);

        log.info("조회 결과 개수: {}", result != null ? result.size() : 0);
        log.debug("조회 결과: {}", result);

        return productRepository.getProductsByCategory(categoryId);
    }

    public List<CategoryProductResponse> getCategoryProductList() {
        return productRepository.getCategoryProductList();
    }
}
