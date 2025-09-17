package com.avengers.musinsa.domain.shipments.entity;

import com.avengers.musinsa.domain.order.entity.OrderItems;
import lombok.Getter;

//상품 배송상태
@Getter
public class ProductShippingStatus {
    private Integer productShippingStatusId;

    private ShippingStatuses shippingStatuses;
    private Long shippingStatusId;

    private OrderItems orderItem;
    private Long orderItemId;

    private String trackNumber;

}
