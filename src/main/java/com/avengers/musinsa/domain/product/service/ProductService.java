package com.avengers.musinsa.domain.product.service;

import com.avengers.musinsa.domain.product.dto.ProductResponseDto;
import com.avengers.musinsa.domain.product.entity.Products;
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
@Service
@RequiredArgsConstructor
public class ProductService {
    // 의존성 주입

    private final ProductRepository productRepository;

    // 아래부터 수정 코드
    private final ProductMapper productMapper;

    public List<ProductResponseDto> getProductById(Long ProductId) {
        List<Products> productList = Collections.singletonList(productRepository.findProductById(ProductId));

        return productList.stream()
                .map(product -> ProductResponseDto.builder()
                        .productId(product.getProductId())

                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .productLikeCnt(product.getProductLikes())
                        .brandId(product.getBrand().getBrandId())
                        .brandName(product.getBrand().getNameKr())
                        .brandLikeCnt(product.getBrand().getBrandLikes())
                        .build())
                .collect(Collectors.toList());

    public List<RecommendationResponse> getRecommendationProductList(Gender gender) {
        return productRepository.getRecommendationProductList(gender);
    }
}
