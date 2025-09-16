package com.avengers.musinsa.review;

import lombok.Getter;

@Getter
public class ProductLikes {
    private Long productLikeId;
    private Users user;
    private Products product;
}
