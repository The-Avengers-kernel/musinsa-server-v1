package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.product.dto.ProductResponseDto;
import com.avengers.musinsa.domain.product.entity.Product;
import com.avengers.musinsa.domain.product.entity.ProductImage;
import com.avengers.musinsa.mapper.ProductMapper;
import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service // 이 클래스는 비즈니스 로직을 담당하는 서비스라는 애너테이션
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 만들어준다.
public class ProductService {
    // 의존성 주입
    private final ProductRepository productRepository;

    public ProductResponseDto getProductById(Long productId) {
        ProductResponseDto productInfo = productRepository.findProductById(productId);
        List<ProductImage> productImage = productRepository.findProductImageById(productId);
        productInfo.getProductImageList().addAll(productImage);
        return productInfo;
    }


    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productRepository.getRecommendationProductList(gender);
    }
}
