package com.avengers.musinsa.user;

public class UserAddress {
    private Integer userAddressId;

    private User userId;

    private String addressName;

    private String location;

    private String phoneNumber;

    private Integer isDefault;

    private Integer isRecent;

    public Integer getUserAddressId() {
        return userAddressId;
    }

    public User getUserId() {
        return userId;
    }

    public String getAddressName() {
        return addressName;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public Integer getIsRecent() {
        return isRecent;
    }
}
