package com.avengers.musinsa.domain.user.repository;

import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import com.avengers.musinsa.mapper.CartMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    private final CartMapper cartMapper;

    public List<ProductsInCartInfoResponse> getProductsInCart(Long userId) {
        return cartMapper.getProductsInCart(userId);
    }
}
