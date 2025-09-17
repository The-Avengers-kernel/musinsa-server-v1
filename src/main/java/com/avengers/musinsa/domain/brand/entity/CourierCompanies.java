package com.avengers.musinsa.domain.brand.entity;

import lombok.Getter;

@Getter
public class CourierCompanies {
    private Integer courierCompanyId;

    private Brands brand;
    private Long brandId;

    private String courierCompanyName;
    private Integer shippingPrice;
}
