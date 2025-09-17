package com.avengers.musinsa.domain.user.entity;

import com.avengers.musinsa.domain.product.entity.Products;
import lombok.Getter;

@Getter
public class UserCarts {
    private Long userCartId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;

    private Integer cartQuantity;
    private String cartOption;
    private String cartStatus;
}
