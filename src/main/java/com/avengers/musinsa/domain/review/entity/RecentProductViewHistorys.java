package com.avengers.musinsa.domain.review.entity;

import com.avengers.musinsa.domain.product.entity.Products;
import com.avengers.musinsa.domain.user.entity.Users;
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
