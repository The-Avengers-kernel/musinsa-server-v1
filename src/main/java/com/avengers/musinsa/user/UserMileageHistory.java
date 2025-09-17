package com.avengers.musinsa.user;

import com.avengers.musinsa.order.OrderItems;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserMileageHistory {
    private Integer userMileageId;

    private Users user;
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
