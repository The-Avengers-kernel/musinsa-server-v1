package com.avengers.musinsa.domain.user.repository;

import com.avengers.musinsa.domain.user.dto.ProductOptionInfo;
import com.avengers.musinsa.domain.user.dto.ProductsInCartInfoResponse;
import com.avengers.musinsa.mapper.CartMapper;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    private final CartMapper cartMapper;

    public List<ProductsInCartInfoResponse> getProductsInCart(Long userId) {
        return cartMapper.getProductsInCart(userId);
    }

    public ProductOptionInfo productOptionInfo(Long userId, Long productId, Map<Integer, String> productOptions) {
        return cartMapper.productOptionInfo(userId, productId, productOptions);
    }

    public void updateProductOption(Long userId, Long productId, String productOptionName,
                                    Integer quantity) {
        cartMapper.updateProductOption(userId, productId, productOptionName, quantity);
    }


}
