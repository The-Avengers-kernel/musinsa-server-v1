package com.avengers.musinsa.brand.entity;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class EventHashTags {
    private Integer eventHashTagId;
    private String hashTagName;
    private String hashTagImageUrl;
    private Timestamp eventStartDate;
    private Timestamp eventEndDate;
}
