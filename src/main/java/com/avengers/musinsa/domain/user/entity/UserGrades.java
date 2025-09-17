package com.avengers.musinsa.domain.user.entity;

import lombok.Getter;

@Getter
public class UserGrades {
    private Integer gradeId;

    private Users user;
    private Long userId;

    private String gradeName;
    private String gradeCode;
    private Integer minAmount;
    private Integer maxAmount;
}
