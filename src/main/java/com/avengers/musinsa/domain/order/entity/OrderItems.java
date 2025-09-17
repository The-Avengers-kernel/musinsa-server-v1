package com.avengers.musinsa.domain.order.entity;

import com.avengers.musinsa.domain.coupons.entity.Coupons;
import com.avengers.musinsa.domain.product.entity.Products;
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
