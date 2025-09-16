package com.avengers.musinsa.review;

public class UserProductLikes {

    private Long userProductLikeId;

    private Users user;

    private Products product;

    public Products getProduct() {
        return product;
    }

    public Users getUser() {
        return user;
    }

    public Long getUserProductLikeId() {
        return userProductLikeId;
    }
}
