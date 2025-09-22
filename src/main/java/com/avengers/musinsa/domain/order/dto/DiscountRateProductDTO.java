package com.avengers.musinsa.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiscountRateProductDTO {
    private Integer productId;
    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer discountRate;
    private Integer totalPrice;

}
