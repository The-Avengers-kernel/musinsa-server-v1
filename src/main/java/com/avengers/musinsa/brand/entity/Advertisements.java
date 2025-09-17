package com.avengers.musinsa.brand.entity;

import lombok.Getter;

@Getter
public class Advertisements {
    private Integer advertisementId;

    private Brands brand;
    private Long brandId;

    private Integer advertisementPrice;
}
