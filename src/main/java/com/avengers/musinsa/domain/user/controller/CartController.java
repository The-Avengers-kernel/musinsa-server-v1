package com.avengers.musinsa.domain.user.controller;

import com.avengers.musinsa.domain.product.service.ProductService;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import com.avengers.musinsa.domain.user.auth.oauth2.dto.CustomOAuth2User;
import com.avengers.musinsa.domain.user.dto.ProductOptionUpdateRequest;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import com.avengers.musinsa.domain.user.service.CartService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    private final TokenProviderService tokenProviderService;

    @GetMapping("/carts/{userId}")
    public List<ProductsInCartInfoResponse> productsInCart(@PathVariable Long userId) {
        return cartService.getProductsInCart(userId);
    }

//    @PatchMapping("/carts/{productId}")
//    public ProductsInCartInfoResponse updateProductInCart(
//            @PathVariable Long productId,
//            @CookieValue(value = "Authorization", required = false) String authorizationHeader,
//            ProductOptionUpdateRequest productOptionUpdateRequest) {

    /// /        Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
    @PatchMapping("/{userId}/carts/{productId}")
    public List<ProductsInCartInfoResponse> updateProductInCart(
            @PathVariable Long productId,
            @PathVariable Long userId,
            @RequestBody ProductOptionUpdateRequest productOptionUpdateRequest) {
//        Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);

        return cartService.updateProductOption(userId, productId, productOptionUpdateRequest);
    }

}
