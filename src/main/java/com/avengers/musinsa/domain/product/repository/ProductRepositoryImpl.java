package com.avengers.musinsa.domain.product.repository;

import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.dto.search.SearchResponse;
import com.avengers.musinsa.domain.product.entity.Product;

import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import com.avengers.musinsa.domain.product.entity.ProductCategory;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.mapper.ProductMapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository // 이 클래스는 데이터 접근 계층
@RequiredArgsConstructor // 필드를 초기화하는 생성자 코드를 자동으로 만들어주는 애너테이션
public class ProductRepositoryImpl implements ProductRepository {
    // ProductMapper 주입
    private final ProductMapper productMapper;

    // 모든 상품을 조회하는 메서드, 메서드를 호출하면 ProductMapper의 findAllProducts()메소드를 호출해서 반환
    @Override
    public List<Product> findAllProducts() {
        return this.productMapper.findAllProducts();
    }

    // 상품 ID를 받아서 특정 상품 하나를 조회하는 메서드
    @Override
    public ProductDetailResponse findProductById(Long productId) {
        return this.productMapper.findProductById(productId);
    }

    @Override
    public ProductVariantsResponse getProductOption(Long productId) {
        return productMapper.getProductOption(productId);
    }

    @Override
    public List<String> findProductOptionColors(Long productId) {
        return productMapper.findProductOptionColors(productId);
    }

    @Override
    public List<String> findProductOptionMaterials(Long productId) {
        return productMapper.findProductOptionMaterials(productId);
    }

    @Override
    public List<String> findProductOptionSizes(Long productId) {
        return productMapper.findProductOptionSizes(productId);
    }

    @Override
    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productMapper.getRecommendationProductList(gender);
    }

    @Override
    public List<ProductOptionRow> findOptionRowsByProductId(List<Long> productIds) {
        // 상품 ID 검증
        if (productIds == null || productIds.isEmpty()) {
            return List.of();
        }
        return productMapper.findOptionsByProductIds(productIds);
    }

    @Override
    public List<ProductByCategoryResponse> getProductsByCategory(Long categoryId) {
        return productMapper.getProductsByCategory(categoryId);
    }

    @Override
    public List<ProductImage> findProductImageById(Long productId) {
        return productMapper.findProductImageById(productId);
    }

    @Override
    public List<CategoryProductResponse> getCategoryProductList() {
        return productMapper.getCategoryProductList();
    }

    // 상품 리뷰 목록 조회
    @Override
    public List<ProductReviewsResponse> getProductReviews(Long productId) {
        return productMapper.getProductReviews(productId);
    }

    // 상의 실측 사이즈 조회
    @Override
    public List<TopProductDetailSizeListResponse> getTopProductDetailSizeList(Long productId) {
        return productMapper.getTopProductDetailSizeList(productId);
    }

    // 하의 실측 사이즈 조회
    @Override
    public List<BottomProductDetailSizeListResponse> getBottomProductDetailSizeList(Long productId) {
        return productMapper.getBottomProductDetailSizeList(productId);
    }
    // 상품 상세 페이지 카테고리 조회
    @Override
    public ProductCategoryListResponse getProductCategories(Long productId) {
        return productMapper.getProductCategories(productId);
    }

    // 상품 상세 페이지 카테고리 리스트 조회
    @Override
    public List<ProductCategory> getProductCategoriesList(Long productId) {
        return productMapper.getProductCategoriesList(productId);
    }

    // 상품 상세 설명 조회 api
    @Override
    public ProductDetailDescriptionResponse getProductDetailDescription (Long productId){
        return productMapper.getProductDetailDescription(productId);
    }

    @Override
    public List<SearchResponse.ProductInfo> findProductsByBrandId(Long brandId) {
        return productMapper.findProductsByBrandId(brandId);
    }

    // 검색어로 상품 목록 찾기
    @Override
    public List<SearchResponse.ProductInfo> findProductsByKeyword(String[] keywords) {
        return productMapper.findProductsByKeyword(keywords);
    }

    //검색 시 검색어 로그 테이블에 검색 정보 저장하기.
    @Override
    public void saveSearchKeywordLog(String keyword){
        productMapper.saveSearchKeywordLog(keyword);
    }
    //검색 시 브랜드 로그 테이블에 검색 정보 저장하기.
    @Override
    public void saveSearchBrandLog(String brand){
        productMapper.saveSearchBrandLog(brand);
    }



    //user_product_like 테이블에 레코드 추가
    @Override
    public void insertUserProductLike(Long userId, Long productId){
        productMapper.insertUserProductLike(userId, productId);
    }

    //products 테이블의 좋아요 수 +1
    @Override
    public void plusProductLikeCnt(Long productId){
        productMapper.plusProductLikeCnt(productId);
    }

    //레코드 추가 후 회원과 상품의 현재 좋아요 상태를 반환
    @Override
    public ProductLikeResponse getIsLikedProduct(Long userId, Long productId){
        return productMapper.getIsLikedProduct(userId, productId);
    }
}
