package com.avengers.musinsa.domain.product.repository;

import com.avengers.musinsa.domain.product.dto.response.ProductDetailResponse;
import com.avengers.musinsa.domain.product.dto.response.ProductVariantsResponse;
import com.avengers.musinsa.domain.product.entity.Product;

import com.avengers.musinsa.domain.product.dto.response.ProductByCategoryResponse;
import com.avengers.musinsa.domain.product.dto.response.CategoryProductResponse;
import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.mapper.ProductMapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository // 이 클래스는 데이터 접근 계층
@RequiredArgsConstructor // 필드를 초기화하는 생성자 코드를 자동으로 만들어주는 애너테이션
public class ProductRepository {
    // ProductMapper 주입
    private final ProductMapper productMapper;

    // 모든 상품을 조회하는 메서드, 메서드를 호출하면 ProductMapper의 findAllProducts()메소드를 호출해서 반환
    public List<Product> findAllProducts() {
        return this.productMapper.findAllProducts();
    }

    // 상품 ID를 받아서 특정 상품 하나를 조회하는 메서드
    public ProductDetailResponse findProductById(Long productId) {
        return this.productMapper.findProductById(productId);
    }

    public ProductVariantsResponse getProductOption(Long productId) {
        return productMapper.getProductOption(productId);
    }

    public List<String> findProductOptionColors(Long productId) {
        return productMapper.findProductOptionColors(productId);
    }
  
    public List<String> findProductOptionMaterials(Long productId) {
        return productMapper.findProductOptionMaterials(productId);
    }
  
    public List<String> findProductOptionSizes(Long productId) {
        return productMapper.findProductOptionSizes(productId);
    }
  
    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productMapper.getRecommendationProductList(gender);
    }

    public List<ProductByCategoryResponse> getProductsByCategory(Long categoryId) {
        return productMapper.getProductsByCategory(categoryId);
    }
  
    public List<ProductImage> findProductImageById(Long productId) {
        return productMapper.findProductImageById(productId);
    }
  
    public List<CategoryProductResponse> getCategoryProductList() {
        return productMapper.getCategoryProductList();
    }
}
