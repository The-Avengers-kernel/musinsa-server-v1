package com.avengers.musinsa.domain.product.controller;

import ch.qos.logback.core.model.Model;
import com.avengers.musinsa.domain.product.dto.response.MaleRecommendationResponse;
import com.avengers.musinsa.domain.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/main/recommendations/male")
    public List<MaleRecommendationResponse> maleRecommendation(Model model) {
        System.out.println("남성추천상품기능");
        return productService.getMaleRecommendationList();
    }
}
