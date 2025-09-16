package com.avengers.musinsa.review;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class ProductViewLogs {
    private Long productViewLogId;
    private Products product;
    private Users user;
    private Timestamp viewAt;
    private ProductViewType productViewType;
}
