package com.avengers.musinsa.domain.order.dto.response;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@AllArgsConstructor
public class BuyerDto {
    private String name;
    private String email;
    private String phone;
}
