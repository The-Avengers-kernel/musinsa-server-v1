package com.avengers.musinsa.review;

import com.avengers.musinsa.product.Products;
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
