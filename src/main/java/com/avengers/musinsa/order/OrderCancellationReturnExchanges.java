package com.avengers.musinsa.order;

import java.sql.Timestamp;

public class OrderCancellationReturnExchanges {

    private Long orderCancellationReturnExchangesId;

    private OrderItems orderItem;

    private String cancellationReturnExchangeReason;

    private String returnMethod;

    private String returnPickupLocation;

    private String returnDestination;

    private Integer returnShippingFee;

    private Timestamp returnDate;

    private String exchangeMethod;

    private String exchangePickupLocation;

    private String exchangeDestination;

    private Integer exchangeShippingFee;

    private String cancellationReturnExchangeStatus;

    private String returnCarrier;

    private String returnTrackingNumber;

    private String reshipmentCarrier;

    private String reshipTrackingNumber;

    private String refundMethod;

    private String refundStatus;

    private String noticesId;

    private Timestamp completionDate;

    public String getCancellationReturnExchangeReason() {
        return cancellationReturnExchangeReason;
    }

    public String getCancellationReturnExchangeStatus() {
        return cancellationReturnExchangeStatus;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public String getExchangeDestination() {
        return exchangeDestination;
    }

    public String getExchangeMethod() {
        return exchangeMethod;
    }

    public String getExchangePickupLocation() {
        return exchangePickupLocation;
    }

    public Integer getExchangeShippingFee() {
        return exchangeShippingFee;
    }

    public String getNoticesId() {
        return noticesId;
    }

    public Long getOrderCancellationReturnExchangesId() {
        return orderCancellationReturnExchangesId;
    }

    public OrderItems getOrderItem() {
        return orderItem;
    }

    public String getRefundMethod() {
        return refundMethod;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public String getReshipmentCarrier() {
        return reshipmentCarrier;
    }

    public String getReshipTrackingNumber() {
        return reshipTrackingNumber;
    }

    public String getReturnCarrier() {
        return returnCarrier;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public String getReturnDestination() {
        return returnDestination;
    }

    public String getReturnMethod() {
        return returnMethod;
    }

    public String getReturnPickupLocation() {
        return returnPickupLocation;
    }

    public Integer getReturnShippingFee() {
        return returnShippingFee;
    }

    public String getReturnTrackingNumber() {
        return returnTrackingNumber;
    }
}
