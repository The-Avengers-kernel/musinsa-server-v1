package com.avengers.musinsa.domain.user.entity;

import lombok.Getter;

import javax.swing.*;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
public class Users {
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
    private String isMember;
  }
