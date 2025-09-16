package com.avengers.musinsa.user;

import lombok.Getter;

@Getter
public class UserGrades {
    private Integer gradeId;
    private User userId;
    private String gradeName;
    private String gradeCode;
    private Integer minAmount;
    private Integer maxAmount;
}
