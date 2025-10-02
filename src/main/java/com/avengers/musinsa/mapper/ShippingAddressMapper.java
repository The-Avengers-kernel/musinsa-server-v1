package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressCreateDTO;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShippingAddressMapper {
    //배송지 목록 조회
    List<ShippingAddressOrderDTO> findByUserId(@Param("userId") Long userId);

    void insertShippingAddress(ShippingAddressCreateDTO shippingAddressCreate);

    void updateShippingAddress(@Param("shippingAddress") ShippingAddressCreateDTO shippingAddressCreate,
                               @Param("shippingAddressId") Long shippingAddressId,
                               @Param("userId") Long userId);

    void deleteShippingAddress(@Param("shippingAddressId") Long shippingAddressId, @Param("userId") Long userId);

    //r기본 배송지 설정
    void resetDefaultShippingAddress(@Param("userId") Long userId);

    void insertShippingAddressDefault(@Param("userId") Long userId, @Param("shippingAddressId") Long shippingAddressId);

    //특정 배송지를 기본 배송지로 지정
    void setDefaultShippingAddress(@Param("shippingAddressId") Long shippingAddressId, @Param("userId") Long userId);






}
