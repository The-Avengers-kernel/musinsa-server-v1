package com.avengers.musinsa.review;

import java.sql.Timestamp;

public class ProductViewLogs {

    private Long productViewLogId;

    private Products product;

    private Users user;

    private Timestamp viewAt;

    private ProductViewType productViewType;

    public Products getProduct() {
        return product;
    }

    public Long getProductViewLogId() {
        return productViewLogId;
    }

    public ProductViewType getProductViewType() {
        return productViewType;
    }

    public Users getUser() {
        return user;
    }

    public Timestamp getViewAt() {
        return viewAt;
    }
}
