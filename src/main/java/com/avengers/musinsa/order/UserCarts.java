package com.avengers.musinsa.order;

import lombok.Getter;

@Getter
public class UserCarts {
    private Long userCartId;
    private Users user;
    private Products products;
    private Integer cartQuantity;
    private String cartOption;
    private String cartStatus;
}
