package com.avengers.musinsa.review.entity;

import com.avengers.musinsa.product.entity.Products;
import com.avengers.musinsa.user.entity.Users;
import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class RecentProductViewHistorys {
    private Long RecentProductViewHistoryId;

    private Users user;
    private Long userId;

    private Products product;
    private Long productId;

    private Timestamp viewTime;
}
