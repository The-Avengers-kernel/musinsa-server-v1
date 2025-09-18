package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId) {
       return orderRepository.getUserInfo(userId);
    }


    //배송지 목록 조회



    //주문상품 리스트



    //상품별 할인금액 계산


    //주문하기




}
