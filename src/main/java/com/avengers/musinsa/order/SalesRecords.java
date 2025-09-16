package com.avengers.musinsa.order;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class SalesRecords {
    private Long salesRecordId;
    private OrderItems orderItem;
    private Users user;
    private Integer quantity;
    private Integer salePrice;
    private Timestamp saleDate;
}
