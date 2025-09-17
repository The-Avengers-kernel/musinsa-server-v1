package com.avengers.musinsa.domain.product.entity;

import com.avengers.musinsa.domain.user.entity.Users;
import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class ProductViewLogs {
    private Long productViewLogId;

    private Products product;
    private Long productId;

    private Users user;
    private Long userId;

    private Timestamp viewAt;
    private ProductViewType productViewType;
}
