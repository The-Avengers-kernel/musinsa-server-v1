package com.avengers.musinsa.order;

import com.avengers.musinsa.product.Products;
import com.avengers.musinsa.user.Users;
import lombok.Getter;

@Getter
public class UserCarts {
    private Long userCartId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;

    private Integer cartQuantity;
    private String cartOption;
    private String cartStatus;
}
