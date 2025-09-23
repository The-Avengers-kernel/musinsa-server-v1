package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.repository.BrandRepository;
import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.dto.search.SearchResponse;
import com.avengers.musinsa.domain.product.entity.ProductCategory;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.repository.ProductRepositoryImpl;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;

import java.util.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    // 의존성 주입
    private final ProductRepositoryImpl productRepository;
    private final BrandRepository brandRepository;

    @Override
    public ProductDetailResponse getProductById(Long productId) {
        ProductDetailResponse productInfo = productRepository.findProductById(productId);
        List<ProductImage> productImage = productRepository.findProductImageById(productId);
        productInfo.getProductImageList().addAll(productImage);
        return productInfo;
    }

    @Override
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


    @Override
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

    // 상품 리뷰 목록 조회
    @Override
    public List<ProductReviewsResponse> getProductReviews(Long productId) {
        return productRepository.getProductReviews(productId);
    }

    // 상품상세 사이즈 리스트 조회
    @Override
    public Object getProductDetailSizeList(Long productId) {
        // 상품 정보 가져오기
        ProductDetailResponse product = productRepository.findProductById(productId);

        // 상품 컬럼에서 sizeDetailImageId를 찾는다.
        Long sizeDetailImageId = product.getSizeDetailImageId();

        // 1, 2 면 상의 실측 사이즈 조회
        // 3, 4 면 하의 실측 사이즈 조회
        if (sizeDetailImageId == 1L || sizeDetailImageId == 2L) {
            return productRepository.getTopProductDetailSizeList(productId);
        } else if (sizeDetailImageId == 3L || sizeDetailImageId == 4L) {
            return productRepository.getBottomProductDetailSizeList(productId);
        } else {
            return Collections.emptyList();
        }
    }

    // 상품 상세 설명 조회 api
    @Override
    public ProductDetailDescriptionResponse getProductDetailDescription(Long productId) {
     return productRepository.getProductDetailDescription(productId);
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

    @Override
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


    // 상품 상세 페이지 카테고리 조회
    @Override
    public ProductCategoryListResponse getProductCategories(Long productId){
        ProductCategoryListResponse productCategoryListResponse = productRepository.getProductCategories(productId);
        List<ProductCategory> productCategoryList = productRepository.getProductCategoriesList(productId);

        productCategoryListResponse.getProductCategoryList().addAll(productCategoryList);
        return productCategoryListResponse;
    }


    // 상품 검색
    @Override
    public SearchResponse searchProducts(String keyword) {
        // 브랜드 검색 먼저 시도
        // 브랜드 두 개 검색될 경우도 고려하여 코드 작성
        List<BrandResponse> brandList = brandRepository.findByBrandName(keyword);

        if (!brandList.isEmpty()) {
            // 브랜드 검색인 경우
            BrandResponse brand = brandList.getFirst();
            List<SearchResponse.ProductInfo> brandProducts =
                    productRepository.findProductsByBrandId(brand.getBrandId());

            SearchResponse.BrandInfo brandInfo = SearchResponse.BrandInfo.builder()
                    .brandId(brand.getBrandId())
                    .brandNameKr(brand.getBrandNameKr())
                    .brandNameEn(brand.getBrandNameEn())
                    .brandImage(brand.getBrandImage())
                    .brandLikes(brand.getBrandLikes())
                    .totalCount(brandProducts.size())
                    .products(brandProducts)
                    .build();

            return SearchResponse.builder()
                    .searchKeyword(keyword)
                    .brandInfo(brandInfo)
                    .build();
        } else {
            // 상품 검색인 경우
            System.out.println("상품검색 시작");
            String[] keywords = keyword.trim().split("\\s+");
            for(String key : keywords){
                System.out.println("키워드 = " + key);
            }
            List<SearchResponse.ProductInfo> products =
                    productRepository.findProductsByKeyword(keywords);

            if (!products.isEmpty()){
                return SearchResponse.builder()
                        .searchKeyword(keyword)
                        .brandInfo(null)
                        .totalCount(products.size())
                        .products(products)
                        .build();
            }else{
                return null;
            }

        }
    }
}
