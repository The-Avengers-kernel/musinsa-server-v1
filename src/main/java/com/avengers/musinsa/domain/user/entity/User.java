package com.avengers.musinsa.domain.user.entity;

import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
public class User {
    private Integer userId;
    private String name;
    private String nickname;
    private Date birthday;
    private String socialId;
    private String socialType;
    private String activeStatus;
    private Timestamp activeTime;
    private Timestamp inactiveTime;
    private Integer userMileage;
    private String isMember;
}
