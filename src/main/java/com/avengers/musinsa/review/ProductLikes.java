package com.avengers.musinsa.review;

import com.avengers.musinsa.product.Products;
import com.avengers.musinsa.user.Users;
import lombok.Getter;

@Getter
public class ProductLikes {
    private Long productLikeId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;
}
