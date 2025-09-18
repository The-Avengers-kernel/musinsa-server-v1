package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.product.entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    List<Products> findAllProducts();

    Products findProductById(Long productID);

    void insertProduct(Products product);

    List<RecommendationResponse> getRecommendationProductList(@Param("gender") Gender gender);
}
