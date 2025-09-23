package com.avengers.musinsa.domain.product.repository;

import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.dto.search.SearchResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.entity.Product;
import com.avengers.musinsa.domain.product.entity.ProductCategory;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.mapper.ProductMapper;

import java.util.List;

public interface ProductRepository {

    // 모든 상품을 조회하는 메서드, 메서드를 호출하면 ProductMapper의 findAllProducts()메소드를 호출해서 반환
    List<Product> findAllProducts();

    // 상품 ID를 받아서 특정 상품 하나를 조회하는 메서드
    ProductDetailResponse findProductById(Long productId);

    ProductVariantsResponse getProductOption(Long productId);

    List<String> findProductOptionColors(Long productId);

    List<String> findProductOptionMaterials(Long productId);

    List<String> findProductOptionSizes(Long productId);

    List<RecommendationResponse> getRecommendationProductList(Gender gender);

    List<ProductOptionRow> findOptionRowsByProductId(List<Long> productIds);

    List<ProductByCategoryResponse> getProductsByCategory(Long categoryId);


    List<ProductImage> findProductImageById(Long productId);

    List<CategoryProductResponse> getCategoryProductList();
    // 상품 리뷰 목록 조회
    List<ProductReviewsResponse> getProductReviews(Long productId);

    // 상의 실측 사이즈 조회
    List<TopProductDetailSizeListResponse> getTopProductDetailSizeList(Long productId);
    // 하의 실측 사이즈 조회
    List<BottomProductDetailSizeListResponse> getBottomProductDetailSizeList(Long productId);

    // 상품 상세 페이지 카테고리 조회
    ProductCategoryListResponse getProductCategories(Long productId);

    // 상품 상세 페이지 카테고리 리스트 조회
    List<ProductCategory> getProductCategoriesList(Long productId);

    // 상품 상세 설명 조회 api
    ProductDetailDescriptionResponse getProductDetailDescription (Long productId);

    List<SearchResponse.ProductInfo> findProductsByBrandId(Long brandId);

    List<SearchResponse.ProductInfo> findProductsByKeyword(String[] keywords);

    //검색 시 검색어 로그 테이블에 검색 정보 저장하기.
    void saveSearchKeywordLog(String keyword);

    //검색 시 브랜드 로그 테이블에 검색 정보 저장하기.
    void saveSearchBrandLog(String brand);

    //user_product_like 테이블에 레코드 추가
    void insertUserProductLike(Long userId, Long productId);

    //products 테이블의 좋아요 수 +1
    void plusProductLikeCnt(Long productId);

    //레코드 추가 후 회원과 상품의 현재 좋아요 상태를 반환
    ProductLikeResponse getIsLikedProduct(Long userId, Long productId);
}
