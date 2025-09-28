package com.avengers.musinsa.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class MyPageDto {
    private Long userId;
    private String name;
    private String username;
    private String mobile;
    private Integer userMileage;
    private String profileImage;
    private String gradeName;



}
