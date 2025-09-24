package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShippingAddressMapper {
    //배송지 목록 조회
    List<ShippingAddressOrderDTO> findByUserId(@Param("userId") Long userId);

}
