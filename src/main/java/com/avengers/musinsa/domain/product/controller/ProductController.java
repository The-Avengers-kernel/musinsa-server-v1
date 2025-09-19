package com.avengers.musinsa.domain.product.controller;

import ch.qos.logback.core.model.Model;
import com.avengers.musinsa.domain.product.dto.response.ProductByCategoryResponse;
import com.avengers.musinsa.domain.product.dto.response.RecommendationResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //카테고리 선택 시 상품 목록 조회되는 화면
    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<ProductByCategoryResponse>> getProductsByCategory(@PathVariable Long categoryId){
        System.out.println("category_id = " + categoryId );
        List<ProductByCategoryResponse> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

}
