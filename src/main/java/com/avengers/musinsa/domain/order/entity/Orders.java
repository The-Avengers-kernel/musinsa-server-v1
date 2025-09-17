package com.avengers.musinsa.domain.order.entity;

import com.avengers.musinsa.domain.shipments.entity.Shipments;
import com.avengers.musinsa.domain.user.entity.UserAddress;
import com.avengers.musinsa.domain.user.entity.User;
import lombok.Getter;

@Getter
public class Orders {
    private Long orderId;

    private User user;
    private Long userId;

    private UserAddress userAddress;
    private Long userAddressId;

    private Shipments shipment;
    private Long shipmentId;

    private PaymentMethods paymentMethod;
    private Long paymentMethodId;

    private Integer orderNumber;
    private Integer totalPrice;
    private Integer orderDiscountAmount;
    private Integer finalPrice;
    private String orderStatus;
}
