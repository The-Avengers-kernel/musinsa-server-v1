package com.avengers.musinsa.shipments.entity;

import lombok.Getter;

@Getter
public class ScheduledDeliveryInformation {
    private Long scheduledDeliveryInformationId;
    private String local;
    private Integer expectedArrivalDate;
}
