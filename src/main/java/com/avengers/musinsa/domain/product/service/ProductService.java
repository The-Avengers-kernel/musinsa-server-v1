package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.dto.search.SearchResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.entity.ProductCategory;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;

import java.util.*;

public interface ProductService {

    public ProductDetailResponse getProductById(Long productId);

    public ProductVariantsResponse getProductVariants(Long productId);


    public List<RecommendationResponse> getRecommendationProductList(Gender gender);

    public Map<Long, List<ProductsInCartInfoResponse.OptionGroup>> getGroupsByProductIds(List<Long> productIds);

    // 상품 리뷰 목록 조회
    public List<ProductReviewsResponse> getProductReviews(Long productId);
    // 상품상세 사이즈 리스트 조회
    public Object getProductDetailSizeList(Long productId);

    // 상품 상세 설명 조회 api
    public ProductDetailDescriptionResponse getProductDetailDescription(Long productId);


    public List<ProductByCategoryResponse> getProductsByCategory(Long categoryId);

    public List<CategoryProductResponse> getCategoryProductList();

    // 상품 상세 페이지 카테고리 조회
    public ProductCategoryListResponse getProductCategories(Long productId);

    // 상품 검색
    public SearchResponse searchProducts(String keyword);
}
