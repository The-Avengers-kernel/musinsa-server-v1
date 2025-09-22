package com.avengers.musinsa.domain.order.repository;

import com.avengers.musinsa.domain.order.dto.DiscountRateProductDTO;
import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final OrderMapper orderMapper;

    //주문자 기본정보 조회
    public UserInfoDTO getUserInfo(Long userId){
        return this.orderMapper.getUserInfo(userId);}

    //배송지 목록 조회



    //주문상품 리스트



    //상품별 할인금액 계산
    public DiscountRateProductDTO getDiscountRateProduct(Long productId){
        return this.orderMapper.getDiscountRateProduct(productId);
    }



    //주문하기


}
