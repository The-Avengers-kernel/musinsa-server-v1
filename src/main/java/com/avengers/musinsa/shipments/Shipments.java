package com.avengers.musinsa.shipments;

//배송
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

    public Integer getShippingId() {
        return shippingId;
    }

    public ScheduledDeliveryInformation getScheduledDeliveryInformationId() {
        return scheduledDeliveryInformationId;
    }

    public ShippingRequestTypes getShippingRequestTypeId() {
        return shippingRequestTypeId;
    }

    public ShippingStatuses getShippingStatusesId() {
        return shippingStatusesId;
    }

    public String getShippingInquiry() {
        return shippingInquiry;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public String getShippingDirectRequest() {
        return shippingDirectRequest;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
