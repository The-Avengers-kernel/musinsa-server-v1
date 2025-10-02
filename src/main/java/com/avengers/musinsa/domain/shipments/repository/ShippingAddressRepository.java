package com.avengers.musinsa.domain.shipments.repository;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressCreateDTO;
import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import com.avengers.musinsa.mapper.ShippingAddressMapper;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ShippingAddressRepository {
    private final ShippingAddressMapper shippingAddressMapper;

    public List<ShippingAddressOrderDTO> findByUserId(Long userId) {
        return shippingAddressMapper.findByUserId(userId);
    }

    public void insertShippingAddress(ShippingAddressCreateDTO shippingAddressCreate) {
        shippingAddressMapper.insertShippingAddress(shippingAddressCreate);
    }

    public void updateShippingAddress(ShippingAddressCreateDTO shippingAddressCreate, Long shippingAddressId, Long userId) {
        shippingAddressMapper.updateShippingAddress(shippingAddressCreate, shippingAddressId, userId);
    }

    public void deleteShippingAddress(Long shippingAddressId, Long userId) {
        shippingAddressMapper.deleteShippingAddress(shippingAddressId, userId);
    }

    //r기본 배송지 설정
    public void resetDefaultShippingAddress(Long userId){
        shippingAddressMapper.resetDefaultShippingAddress(userId);
    }

    public void insertShippingAddressDefault(@Param("userId") Long userId, @Param("shippingAddressId") Long shippingAddressId){
        shippingAddressMapper.insertShippingAddressDefault(userId, shippingAddressId);
    }

    //특정 배송지를 기본 배송지로 지정
    public void setDefaultShippingAddress(Long shippingAddressId, Long userId){
        shippingAddressMapper.setDefaultShippingAddress(shippingAddressId, userId);
    }

    //특정배송지를






}

