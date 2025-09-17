package com.avengers.musinsa.domain.user.entity;

import com.avengers.musinsa.domain.brand.entity.Brands;
import lombok.Getter;

@Getter
public class UserBrandLikes {
    private Long userBrandLikeId;

    private Brands brand;
    private Long brandId;

    private User user;
    private Long userId;
}
