package com.avengers.musinsa.domain.product.repository;


import com.avengers.musinsa.domain.product.dto.response.MaleRecommendationResponse;
import com.avengers.musinsa.domain.product.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final ProductMapper productMapper;

    public List<MaleRecommendationResponse> getMaleRecommendationList() {
        return productMapper.getRecommendationList();
    }
}
