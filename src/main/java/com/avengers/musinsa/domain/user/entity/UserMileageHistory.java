package com.avengers.musinsa.domain.user.entity;

import com.avengers.musinsa.domain.order.entity.OrderItems;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserMileageHistory {
    private Integer userMileageId;

    private User user;
    private Long userId;

    private OrderItems orderItem;
    private Long orderItemId;

    private UserMileageTypes userMileageType;
    private Long userMileageTypeId;


    private Integer amount;
    private String transactionType;
    private Timestamp earnedAt;
    private Timestamp expiresAt;
}
