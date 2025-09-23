package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.dto.search.SearchResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import java.util.List;
import com.avengers.musinsa.domain.product.entity.Product;
import com.avengers.musinsa.domain.product.entity.ProductCategory;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ProductMapper {
    List<Product> findAllProducts();

    ProductDetailResponse findProductById(Long productID);

    List<RecommendationResponse> getRecommendationProductList(@Param("gender") Gender gender);

    List<ProductOptionRow> findOptionsByProductIds(@Param("productIds") List<Long> productIds);
    
    List<ProductByCategoryResponse> getProductsByCategory(Long categoryId);
  
    List<ProductImage> findProductImageById(Long productId);

    ProductVariantsResponse getProductOption(Long productId);

    List<String> findProductOptionColors(Long productId);
  
    List<String> findProductOptionMaterials(Long productId);
  
    List<String> findProductOptionSizes(Long productId);

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

    ProductDetailDescriptionResponse getProductDetailDescription(Long productId);

    List<SearchResponse.ProductInfo> findProductsByBrandId(Long brandId);

    List<SearchResponse.ProductInfo> findProductsByKeyword(@Param("keywords") String[] keywords);

    //user_product_like 테이블에 레코드 추가
    void insertUserProductLike(Long userId, Long productId);

    //products 테이블의 좋아요 수+1
    void plusProductLikeCnt(Long productId);

    //레코드 추가 후 회원과 상품의 현재 좋아요 상태를 반환
    ProductLikeResponse getIsLikedProduct(Long userId, Long productId);

}