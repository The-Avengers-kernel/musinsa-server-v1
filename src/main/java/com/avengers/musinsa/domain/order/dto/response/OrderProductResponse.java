package com.avengers.musinsa.domain.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderProductResponse {
    private List<OrderProductDTO> products;
    private Integer totalPrice;
}
