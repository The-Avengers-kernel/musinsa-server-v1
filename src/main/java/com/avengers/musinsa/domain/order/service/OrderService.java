package com.avengers.musinsa.domain.order.service;

import com.avengers.musinsa.domain.order.dto.OrderProductDTO;
import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.repository.OrderRepository;
import com.avengers.musinsa.domain.product.entity.Product;
import com.avengers.musinsa.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<OrderProductDTO> getOrderProducts(Long productId){
        return orderRepository.getOrderProducts(productId);
    }




    //상품별 할인금액 계산


    //주문하기




}
