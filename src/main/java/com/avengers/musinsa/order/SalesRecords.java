package com.avengers.musinsa.order;

import java.sql.Timestamp;

public class SalesRecords {

    private Long salesRecordId;

    private OrderItems orderItem;

    private Users user;

    private Integer quantity;

    private Integer salePrice;

    private Timestamp saleDate;

    public OrderItems getOrderItem() {
        return orderItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public Long getSalesRecordId() {
        return salesRecordId;
    }

    public Users getUser() {
        return user;
    }
}
