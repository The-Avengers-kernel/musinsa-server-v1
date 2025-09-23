package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.Payment;
import com.avengers.musinsa.domain.order.dto.request.OrderCreateRequest.ProductLine;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    //주문자 기본정보 조회
    UserInfoDTO getUserInfo(@Param("userId") Long userId);

    //배송지 목록 조회

    //주문상품 리스트

    //상품별 할인금액 계산


    //주문하기
    int createShipment(OrderCreateRequest orderCreateRequest);

    int createOrder(@Param("userId") Long userId,
                    @Param("shippingId") Long shippingId,
                    @Param("userAddressId") Long userAddressId,
                    @Param("payment") Payment payment);

    void createOrderItems(@Param("orderId") Long orderId,
                          @Param("product") ProductLine orderProduct);
}
