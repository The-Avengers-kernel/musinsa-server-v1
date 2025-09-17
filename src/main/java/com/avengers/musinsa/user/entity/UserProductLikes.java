package com.avengers.musinsa.user.entity;

import com.avengers.musinsa.product.entity.Products;
import lombok.Getter;

@Getter
public class UserProductLikes {
    private Long userProductLikeId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;
}
