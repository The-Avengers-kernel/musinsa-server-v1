package com.avengers.musinsa.domain.shipments.repository;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressOrderDTO;
import com.avengers.musinsa.domain.shipments.entity.Shipment;
import com.avengers.musinsa.mapper.ShippingAddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ShippingAddressRepository {
    private final ShippingAddressMapper shippingAddressMapper;

    public List<ShippingAddressOrderDTO> findByUserId(Long userId) {
        return shippingAddressMapper.findByUserId(userId);

    }

//    public Shipment findByShipmentId(Long shipmentId) {
//        shippingAddressMapper.findByUserId
//    }
}

