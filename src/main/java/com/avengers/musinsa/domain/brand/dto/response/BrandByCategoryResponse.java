package com.avengers.musinsa.domain.brand.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BrandByCategoryResponse {
    private Long brandCategoryId;
    private String categoryName;
    private Long brandId;
    private String brandNameKr;
    private String brandNameEn;
    private String brandImage;
}