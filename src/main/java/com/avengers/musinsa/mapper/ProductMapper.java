package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.product.dto.ProductResponseDto;
import com.avengers.musinsa.domain.product.entity.Product;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    List<Product> findAllProducts();

    ProductResponseDto findProductById(Long productID);

    List<RecommendationResponse> getRecommendationProductList(@Param("gender") Gender gender);


    List<ProductImage> findProductImageById(Long productId);
}
