package com.avengers.musinsa.review;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class RecentProductViewHistorys {
    private Long RecentProductViewHistoryId;
    private Users user;
    private Products product;
    private Timestamp viewTime;
}
