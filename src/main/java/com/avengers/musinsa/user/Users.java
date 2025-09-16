package com.avengers.musinsa.user;

import java.sql.Date;
import java.sql.Timestamp;

public class Users {
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

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getSocialType() {
        return socialType;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public Integer getUserMileage() {
        return userMileage;
    }

    public String getIsMember() {
        return isMember;
    }
}
