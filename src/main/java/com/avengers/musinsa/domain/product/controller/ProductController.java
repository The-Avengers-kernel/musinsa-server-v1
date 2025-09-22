package com.avengers.musinsa.domain.product.controller;

import ch.qos.logback.core.model.Model;
import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 이 클래스는 API용 컨트롤러라는 애너테이션
@RequestMapping("/api/v1/products") // 이 컨트롤러의 모든 API는 /api/v1/products로 시작
@RequiredArgsConstructor
public class ProductController {
    // 서비스 계층에 일을 시킨다, 주입

    private final ProductService productService;

    // /api/v1/products/{숫자} 형태의 url 요청을 받아서,
    // 그 숫자를 productId 변수로 넘겨주는 역할
    @GetMapping("{productId}")
    // get은 임의로 정한 메서드 이름 나중에 바꾸면 된다.
    // @PathVariable은 Spring MVC에서 URL 경로의 일부 값을 메서드의 매개변수로 바인딩 해주는 애너테이션 없으면 오류가 난다.
    public ProductDetailResponse getDetailProduct(@PathVariable Long productId){
        // "해당 productId 상품 정보를 반환해준다.
        return productService.getProductById(productId);
    }

    @GetMapping("/{productId}/options")
    public ProductVariantsResponse getProductVariants(@PathVariable Long productId){
        return productService.getProductVariants(productId);
    }


    @GetMapping("/main/recommendations/{gender}")
    public List<RecommendationResponse> recommendationProducts(@PathVariable String gender ) {
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

    @GetMapping("/categories/products")
    public List<CategoryProductResponse> categoryProducts() {
        return productService.getCategoryProductList();
    }

    // 상품 상세 설명 조회 api
    @GetMapping("/{productId}/detail-Info")
    public ProductDetailDescriptionResponse getProductDetailDescription(@PathVariable Long productId){
        return productService.getProductDetailDescription(productId);

    }
}
