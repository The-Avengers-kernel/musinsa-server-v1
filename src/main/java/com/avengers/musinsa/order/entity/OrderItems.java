package com.avengers.musinsa.order.entity;

import com.avengers.musinsa.coupons.entity.Coupons;
import com.avengers.musinsa.product.entity.Products;
import lombok.Getter;

@Getter
public class OrderItems {
    private Long orderItemId;

    private Products product;
    private Long productId;

    private Coupons coupon;
    private Long couponId;

    private Orders order;
    private Long orderId;

    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;
}
