package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.product.dto.response.MaleRecommendationResponse;
import com.avengers.musinsa.domain.product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<MaleRecommendationResponse> getMaleRecommendationList() {
        return productRepository.getMaleRecommendationList();
    }
}
