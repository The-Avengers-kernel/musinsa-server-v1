package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import java.util.List;
import com.avengers.musinsa.domain.product.entity.Product;
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

    // 상의 실측 사이즈 조회
    List<TopProductDetailSizeListResponse> getTopProductDetailSizeList(Long productId);

    // 하의 실측 사이즈 조회
    List<BottomProductDetailSizeListResponse> getBottomProductDetailSizeList(Long productId);
}