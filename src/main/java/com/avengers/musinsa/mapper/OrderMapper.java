package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.order.dto.DiscountRateProductDTO;
import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
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

    DiscountRateProductDTO getDiscountRateProduct(@Param("productId") Long productId);


    //주문하기


}
