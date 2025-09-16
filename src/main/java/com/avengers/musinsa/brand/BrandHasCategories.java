package com.avengers.musinsa.brand;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class BrandHasCategories {
    private Integer brandHasCategoryId;

    private BrandCategories brandCategory;
    private Long brandCategoryId;

    private Brands brandId;
}
