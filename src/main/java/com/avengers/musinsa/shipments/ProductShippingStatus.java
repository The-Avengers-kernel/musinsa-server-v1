package com.avengers.musinsa.shipments;

import com.avengers.musinsa.order.OrderItems;
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
