package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    //주문자 기본정보 조회
    @Select("SELECT u.user_id as userId, u.user_name as userName, ua.phone_number as phoneNumber, ua.address_line1 || ' ' || ua.address_line2 AS location FROM USERS u JOIN user_addresses ua ON u.user_id = ua.user_id WHERE u.user_id = #{userId} AND ua.is_default = 1")
    UserInfoDTO getUserInfo(@Param("userId") Long userId);

    //배송지 목록 조회



    //주문상품 리스트




    //상품별 할인금액 계산


    //주문하기


}
