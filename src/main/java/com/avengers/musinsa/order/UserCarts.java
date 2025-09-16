package com.avengers.musinsa.order;

public class UserCarts {

    private Long userCartId;

    private Users user;

    private Products products;

    private Integer cartQuantity;

    private String cartOption;

    private String cartStatus;

    public String getCartOption() {
        return cartOption;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public Products getProducts() {
        return products;
    }

    public Users getUser() {
        return user;
    }

    public Long getUserCartId() {
        return userCartId;
    }
}
