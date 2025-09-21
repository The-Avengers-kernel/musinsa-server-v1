package com.avengers.musinsa.domain.order.dto.response;

import com.avengers.musinsa.domain.order.entity.OrderItem;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrderItemsDto {

    private List<OrderItemDto> orderItemDtos;
}
