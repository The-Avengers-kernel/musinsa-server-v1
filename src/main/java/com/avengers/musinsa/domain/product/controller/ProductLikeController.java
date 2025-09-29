package com.avengers.musinsa.domain.product.controller;

import com.avengers.musinsa.domain.product.dto.response.ProductLikeResponse;
import com.avengers.musinsa.domain.product.service.ProductService;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductLikeController {
    private final ProductService productService;
    private final TokenProviderService tokenProviderService;

    //상품 좋아요 토글 기능
    @PostMapping("/products/{productId}/liked")
    public ProductLikeResponse ProductLikeToggle(@PathVariable Long productId, @CookieValue(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization token is missing");
        } else {
            Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
            System.out.println("userId = " + userId);
            return productService.ProductLikeToggle(userId, productId);
        }
    }

    //상품 좋아요 토글 기능
//    @PostMapping("/{userId}/products/{productId}/liked")
//    public ProductLikeResponse ProductLikeToggle(@PathVariable Long productId, @PathVariable Long userId) {
//            return productService.ProductLikeToggle(userId, productId);
//        }

}
