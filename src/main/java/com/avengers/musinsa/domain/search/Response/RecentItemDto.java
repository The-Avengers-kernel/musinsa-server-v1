package com.avengers.musinsa.domain.search.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecentItemDto {
    private String type;

    //brand 관련
    private Long brandId;
    private String brandName;
    private String brandImageUrl;

    //product 관련
    private Long productId;
    private String productName;
    private String productImageUrl;


}
