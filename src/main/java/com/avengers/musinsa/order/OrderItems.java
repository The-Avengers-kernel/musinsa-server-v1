package com.avengers.musinsa.order;

import lombok.Getter;

@Getter
public class OrderItems {
    private Long orderItemId;
    private Products product;
    private Coupons coupon;
    private Orders order;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
}
