package com.avengers.musinsa.domain.shipments.service;

import com.avengers.musinsa.domain.shipments.dto.ShippingAddressDTO;
import com.avengers.musinsa.domain.shipments.repository.ShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ShippingAddressService {
    private final ShippingAddressRepository shippingAddressRepository;

    public List<ShippingAddressDTO> getShippingAddresses(Long userId) {
        return shippingAddressRepository.findByUserId(userId);
    }


}
