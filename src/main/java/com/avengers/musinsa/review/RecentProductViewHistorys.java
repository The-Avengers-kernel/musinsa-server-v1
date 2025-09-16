package com.avengers.musinsa.review;

import java.sql.Timestamp;

public class RecentProductViewHistorys {

    private Long RecentProductViewHistoryId;

    private Users user;

    private Products product;

    private Timestamp viewTime;

    public Products getProduct() {
        return product;
    }

    public Long getRecentProductViewHistoryId() {
        return RecentProductViewHistoryId;
    }

    public Users getUser() {
        return user;
    }

    public Timestamp getViewTime() {
        return viewTime;
    }
}
