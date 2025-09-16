package com.avengers.musinsa.brand;

import java.sql.Timestamp;

public class EventHashTags {
    private Integer eventHashTagId;

    private String hashTagName;

    private String hashTagImageUrl;

    private Timestamp eventStartDate;

    private Timestamp eventEndDate;

    public Integer getEventHashTagId() {
        return eventHashTagId;
    }

    public String getHashTagName() {
        return hashTagName;
    }

    public String getHashTagImageUrl() {
        return hashTagImageUrl;
    }

    public Timestamp getEventStartDate() {
        return eventStartDate;
    }

    public Timestamp getEventEndDate() {
        return eventEndDate;
    }
}
