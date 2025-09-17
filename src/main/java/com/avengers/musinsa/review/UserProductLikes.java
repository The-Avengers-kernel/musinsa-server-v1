package com.avengers.musinsa.review;

import com.avengers.musinsa.product.Products;
import com.avengers.musinsa.domain.user.entity.Users;
import lombok.Getter;

@Getter
public class UserProductLikes {
    private Long userProductLikeId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;
}
