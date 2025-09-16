package com.avengers.musinsa.shipments;

import java.sql.Timestamp;
import java.util.Date;

//배송상태
public class ShippingStatuses {
    private Integer shippingStatuses;
    private String status;
    private String hubName;
    private String hubStatus;
    private Timestamp arrivalTime;
    private Timestamp departureTime;

    public Integer getShippingStatuses() {
        return shippingStatuses;
    }

    public String getStatus() {
        return status;
    }

    public String getHubName() {
        return hubName;
    }

    public String getHubStatus() {
        return hubStatus;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }
}
