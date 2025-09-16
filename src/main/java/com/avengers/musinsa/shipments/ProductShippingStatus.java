package com.avengers.musinsa.shipments;

import lombok.Getter;

//상품 배송상태
@Getter
public class ProductShippingStatus {
    private Integer productShippingStatusId;
    private ShippingStatuses shippingStatusesId;
    private OrderItems orderItemId;
    private String trackNumber;

}
