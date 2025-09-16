package com.avengers.musinsa.review;

public class ProductLikes {

    private Long productLikeId;

    private Users user;

    private Products product;

    public Products getProduct() {
        return product;
    }

    public Long getProductLikeId() {
        return productLikeId;
    }

    public Users getUser() {
        return user;
    }
}
