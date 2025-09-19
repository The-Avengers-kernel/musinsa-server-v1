package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.product.dto.response.ProductByCategoryDto;
import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productRepository.getRecommendationProductList(gender);
    }

    public List<ProductByCategoryDto> getProductsByCategory(Long categoryId) {
        log.info("카테고리 ID로 상품 조회 시작: {}", categoryId);

        List<ProductByCategoryDto> result = productRepository.getProductsByCategory(categoryId);

        log.info("조회 결과 개수: {}", result != null ? result.size() : 0);
        log.debug("조회 결과: {}", result);

        return productRepository.getProductsByCategory(categoryId);
    }
}
