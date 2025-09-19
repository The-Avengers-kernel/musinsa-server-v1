package com.avengers.musinsa.domain.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CategoryProductResponse {
    private Long productCategoryID;
    private Long parentProductCategoryId;
    private String categoryName;
    private String categoryImage;
    private int categoryLevel;
}
