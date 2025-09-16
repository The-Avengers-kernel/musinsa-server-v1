package com.avengers.musinsa.shipments;

import lombok.Getter;

//배송
@Getter
public class Shipments {
    private Integer shippingId;
    private ScheduledDeliveryInformation scheduledDeliveryInformationId;
    private ShippingRequestTypes shippingRequestTypeId;
    private ShippingStatuses shippingStatusesId;
    private String shippingInquiry;
    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private String shippingDirectRequest;
    private String postalCode;

}
