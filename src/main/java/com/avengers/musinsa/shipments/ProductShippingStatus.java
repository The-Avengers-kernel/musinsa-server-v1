package com.avengers.musinsa.shipments;

import lombok.Getter;

//상품 배송상태
@Getter
public class ProductShippingStatus {
    private Integer productShippingStatusId;
    private ShippingStatuses shippingStatusesId;
    private OrderItems orderItemId;
    private String trackNumber;

    public Integer getProductShippingStatusId() {
        return productShippingStatusId;
    }

    public ShippingStatuses getShippingStatusesId() {
        return shippingStatusesId;
    }

    public OrderItems getOrderItemId() {
        return orderItemId;
    }

    public String getTrackNumber() {
        return trackNumber;
    }
}
