package com.avengers.musinsa.product.entity;

import com.avengers.musinsa.user.entity.Users;
import lombok.Getter;

@Getter
public class ProductLikes {
    private Long productLikeId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;
}
