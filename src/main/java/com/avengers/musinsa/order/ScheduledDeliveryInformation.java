package com.avengers.musinsa.order;

public class ScheduledDeliveryInformation {

    private Long scheduledDeliveryInformationId;

    private String local;

    private Integer expectedArrivalDate;

    public Integer getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    public String getLocal() {
        return local;
    }

    public Long getScheduledDeliveryInformationId() {
        return scheduledDeliveryInformationId;
    }
}
