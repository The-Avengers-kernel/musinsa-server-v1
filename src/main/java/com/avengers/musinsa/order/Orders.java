package com.avengers.musinsa.order;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
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
}
