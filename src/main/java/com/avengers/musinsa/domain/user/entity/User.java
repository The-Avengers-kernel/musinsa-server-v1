package com.avengers.musinsa.domain.user.entity;

import lombok.Getter;

import javax.swing.*;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
public class User {
    private Integer userId;
    private String name;
    private String nickname;
    private Date birthday;
    private Integer birthyear;
    private String gender;
    private String email;
    private String mobile;
    private String ageGroup;


    private String socialId;
    private String socialType;
    private String activeStatus;
    private Timestamp activeTime;
    private Timestamp inactiveTime;
    private Integer userMileage;

    // OAuth2용 추가 필드
    private String username; // OAuth2에서 사용하는 복합키
    private String role;

    // OAuth2용 간단 생성자
    public User(String username, String email, String name, String role) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.role = role;

    }
}
