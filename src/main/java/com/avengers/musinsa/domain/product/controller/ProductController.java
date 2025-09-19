package com.avengers.musinsa.domain.product.controller;

import ch.qos.logback.core.model.Model;
import com.avengers.musinsa.domain.product.dto.response.CategoryProductResponse;
import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.entity.ProductCategory;
import com.avengers.musinsa.domain.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/main/recommendations/{gender}")
    public List<RecommendationResponse> recommendationProducts(@PathVariable String gender, Model model) {
        Gender g = Gender.valueOf(gender.toUpperCase());
        return productService.getRecommendationProductList(g);
    }
    @GetMapping("/categories/products")
    public List<CategoryProductResponse> categoryProducts() {
        return productService.getCategoryProductList();
    }
}
