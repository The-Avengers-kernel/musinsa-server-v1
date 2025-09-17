package com.avengers.musinsa.domain.order.entity;

import com.avengers.musinsa.domain.user.entity.Users;
import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class SalesRecords {
    private Long salesRecordId;

    private OrderItems orderItem;
    private Long orderItemId;

    private Users user;
    private Long userId;

    private Integer quantity;
    private Integer salePrice;
    private Timestamp saleDate;
}
