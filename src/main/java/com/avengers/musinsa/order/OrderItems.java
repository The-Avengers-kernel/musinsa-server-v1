package com.avengers.musinsa.order;

public class OrderItems {

    private Long orderItemId;

    private Products product;

    private Coupons coupon;

    private Orders order;

    private Integer quantity;

    private Integer unitPrice;

    private Integer totalPrice;

    public Coupons getCoupon() {
        return coupon;
    }

    public Orders getOrder() {
        return order;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public Products getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }
}
