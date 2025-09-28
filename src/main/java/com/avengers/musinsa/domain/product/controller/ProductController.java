package com.avengers.musinsa.domain.product.controller;

import com.avengers.musinsa.domain.product.dto.response.*;
import com.avengers.musinsa.domain.product.dto.search.SearchResponse;
import com.avengers.musinsa.domain.product.entity.Gender;
import com.avengers.musinsa.domain.product.service.ProductServiceImpl;
import java.util.List;

import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 이 클래스는 API용 컨트롤러라는 애너테이션
@RequestMapping("/api/v1/products") // 이 컨트롤러의 모든 API는 /api/v1/products로 시작
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
    private final TokenProviderService tokenProviderService;

    // "해당 productId 상품 정보를 반환해준다.
    @GetMapping("{productId}")
    public ProductDetailResponse getDetailProduct(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/{productId}/options")
    public List<ProductVariantDetailDto> getProductVariants(@PathVariable Long productId) {
        return productService.getProductVariants(productId);
    }

    // 상풍 상세 페이지 카테고리 조회
    @GetMapping("/{productId}/categories")
    public ProductCategoryListResponse getProductCategories(@PathVariable Long productId) {
        return productService.getProductCategories(productId);
    }


    // 무신사 추천순
    @GetMapping("/recommendations/{gender}")
    public List<RecommendationResponse> recommendationProducts(@PathVariable String gender) {
        Gender g = Gender.valueOf(gender.toUpperCase());
        return productService.getRecommendationProductList(g);
    }

    //카테고리 선택 시 상품 목록 조회되는 화면
      @GetMapping("/category/{categoryId}")
      public ResponseEntity<List<ProductByCategoryResponse>> getProductsByCategory(@PathVariable Long categoryId) {
        System.out.println("category_id = " + categoryId);
        List<ProductByCategoryResponse> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    // 상품 리뷰 목록 조회
    @GetMapping("{productId}/reviews")
    public List<ProductReviewsResponse> getProductReviews(@PathVariable Long productId) {
        return productService.getProductReviews(productId);
    }

    // 상품상세 사이즈 리스트 조회
    @GetMapping("{productId}/detail-size-list")
    public Object getProductDetailSizeList(@PathVariable Long productId) {
        return productService.getProductDetailSizeList(productId);
    }

    // 상품 상세 설명 조회 api
    @GetMapping("/{productId}/detail-Info")
    public ProductDetailDescriptionResponse getProductDetailDescription(@PathVariable Long productId) {
        return productService.getProductDetailDescription(productId);

    }


    // 상품 검색에 따른 상품 목록 조회
    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(@RequestParam("keyword") String keyword,
                                            @CookieValue(value = "Authorization", required = false) String authorizationHeader) {
        System.out.println(keyword);
        Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
        SearchResponse response = productService.searchProducts(keyword, userId);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok("검색 결과가 없습니다.");
        }

    }
}
