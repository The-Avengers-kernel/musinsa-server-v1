package com.avengers.musinsa.domain.product.entity;

import com.avengers.musinsa.domain.user.entity.User;
import lombok.Getter;

@Getter
public class ProductLikes {
    private Long productLikeId;

    private User user;
    private Long userId;

    private Products product;
    private Long productId;
}
