package com.avengers.musinsa.domain.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DiscountRateProductDTO {
    private Integer productId;
    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer discountRate;
    private Integer totalPrice;
}
