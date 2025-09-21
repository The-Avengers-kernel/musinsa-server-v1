package com.avengers.musinsa.domain.product.dto.response;

import com.avengers.musinsa.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductDetailSizeList {
    private Long topSizeDetailId;

    private String cm;
    private BigDecimal length;
    private BigDecimal shoulderWidth;
    private BigDecimal chestWidth;
    private BigDecimal sleaveLength;


}
