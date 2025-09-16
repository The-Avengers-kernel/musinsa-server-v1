package com.avengers.musinsa.review;

import lombok.Getter;

@Getter
public class UserProductLikes {
    private Long userProductLikeId;
    private Users user;
    private Products product;
}
