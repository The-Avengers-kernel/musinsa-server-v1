package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.Payment;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.ProductLine;
import com.avengers.musinsa.domain.order.dto.response.OrderCreateResponse;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId) {
        return orderRepository.getUserInfo(userId);
    }

    //배송지 목록 조회

    //상품별 할인금액 계산


    //주문하기
    @Transactional
    public OrderCreateResponse createOrder(Long userId, OrderCreateRequest orderCreateRequest) {
        // 배송 예정 정보ID, 배송 요청사항 타입ID, 배송 상태 ID와 여러 배송 정보 배송정보 테이블에 저장
        // 과 동시에 배송테이블 ID 가져오기
        Long shippingId = orderRepository.createShipment(orderCreateRequest);

        // 주문 정보 저장 후 주문 ID 가져오기
        Long userAddressId = orderCreateRequest.getAddressId();
        Long orderId = orderRepository.createOrder(userId, shippingId, userAddressId, orderCreateRequest.getPayment());

        // 주문서 상품 내역 주문한 상품들 순회하며 저장
        List<OrderCreateRequest.ProductLine> orderProducts = orderCreateRequest.getProduct();
        for (ProductLine orderProduct : orderProducts) {
            orderRepository.createOrderItems(orderId, orderProduct);
        }

        // 상품 판매 내역 - 해야하는데 주문서 상품 내역 저장과 같은 방식이라 안 함
        OrderCreateResponse orderCreateResponse = new OrderCreateResponse(orderId);

        return orderCreateResponse;
    }
}

