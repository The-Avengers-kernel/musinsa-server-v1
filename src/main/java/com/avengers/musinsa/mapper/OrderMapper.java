package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.order.dto.OrderCompletionInfoDto;
import com.avengers.musinsa.domain.order.dto.response.OrderDto;
import com.avengers.musinsa.domain.order.dto.response.UserInfoDTO;
import com.avengers.musinsa.domain.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    //주문자 기본정보 조회
    UserInfoDTO getUserInfo(@Param("userId") Long userId);


    // 주문 조회
    Order getOrder(@Param("orderId") Long orderId);

    // 주문 상품 리스트 조회
    List<OrderDto.OrderItemInfo> findOrderItems(Long orderId);

    //배송지 목록 조회



    //주문상품 리스트




    //상품별 할인금액 계산


    //주문하기


}
