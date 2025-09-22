package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.domain.order.dto.DiscountRateProductDTO;
import com.avengers.musinsa.domain.order.dto.OrderProductDTO;
import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import com.avengers.musinsa.domain.product.dto.ProductListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public DiscountRateProductDTO getDiscountRateProduct(Long productId) {
        return orderRepository.getDiscountRateProduct(productId);
    }



    //주문하기




}
