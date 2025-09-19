package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.dto.ProductOptionRow;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    List<RecommendationResponse> getRecommendationProductList(@Param("gender") Gender gender);

    List<ProductOptionRow> findOptionsByProductIds(@Param("productIds") List<Long> productIds);
}
