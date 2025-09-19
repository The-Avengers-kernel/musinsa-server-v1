package com.avengers.musinsa.domain.user.controller;

import com.avengers.musinsa.domain.product.service.ProductService;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import com.avengers.musinsa.domain.user.service.CartService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/carts/{userId}")
    public List<ProductsInCartInfoResponse> productsInCart(@PathVariable Long userId) {
        return cartService.getProductsInCart(userId);
    }

}
