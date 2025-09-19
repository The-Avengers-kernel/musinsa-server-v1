package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.product.dto.response.ProductByCategoryResponse;
import com.avengers.musinsa.domain.product.dto.response.ProductDetailResponse;
import com.avengers.musinsa.domain.product.dto.response.ProductVariantsResponse;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.domain.product.dto.response.CategoryProductResponse;
import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.repository.ProductRepository;
import java.util.List;
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
