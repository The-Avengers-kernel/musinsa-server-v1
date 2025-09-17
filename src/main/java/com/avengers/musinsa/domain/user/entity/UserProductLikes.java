package com.avengers.musinsa.domain.user.entity;

import com.avengers.musinsa.domain.product.entity.Products;
import lombok.Getter;

@Getter
public class UserProductLikes {
    private Long userProductLikeId;

    private User user;
    private Long userId;

    private Products product;
    private Long productId;
}
