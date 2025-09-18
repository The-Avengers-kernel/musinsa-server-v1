package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.product.entity.Product;
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

    Product findProductById( Long productID);

    void insertProduct(Product product);

    List<RecommendationResponse> getRecommendationProductList(@Param("gender") Gender gender);
}
