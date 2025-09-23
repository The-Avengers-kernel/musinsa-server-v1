package com.avengers.musinsa.domain.order.repository;

import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.Payment;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.ProductLine;
import com.avengers.musinsa.mapper.OrderMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final OrderMapper orderMapper;

    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId) {
        return this.orderMapper.getUserInfo(userId);
    }

    //배송지 목록 조회

    //주문상품 리스트

    //상품별 할인금액 계산


    //주문하기
    public Long createShipment(OrderCreateRequest orderCreateRequest) {
        orderMapper.createShipment(orderCreateRequest);
        return orderCreateRequest.getShipping().getShippingId();
    }


    public Long createOrder(Long userId, Long shippingId, Long userAddressId, OrderCreateRequest.Payment payment) {
        orderMapper.createOrder(userId, shippingId, userAddressId, payment);
        return payment.getOrderId();
    }

    public void createOrderItems(Long orderId, ProductLine orderProduct) {
        orderMapper.createOrderItems(orderId, orderProduct);
    }
}
