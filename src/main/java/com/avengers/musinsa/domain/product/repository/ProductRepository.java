package com.avengers.musinsa.domain.product.repository;


import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final ProductMapper productMapper;

    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productMapper.getRecommendationProductList(gender);
    }
}
