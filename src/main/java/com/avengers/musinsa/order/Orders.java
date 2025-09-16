package com.avengers.musinsa.order;

import java.sql.Timestamp;

public class Orders {

    private Long orderId;

    private Users user;

    private UserAddress userAddress;

    private Shipping shipping;

    private PaymentMethod paymentMethod;

    private Integer orderNumber;

    private Integer totalPrice;

    private Integer orderDiscountAmount;

    private Integer finalPrice;

    private String orderStatus;

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public Integer getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public Users getUser() {
        return user;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }
}
