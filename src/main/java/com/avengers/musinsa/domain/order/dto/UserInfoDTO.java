package com.avengers.musinsa.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserInfoDTO {
    private Integer userId;
    private String userName;
    private String phoneNumber;
    private String location;

//    public UserInfoDTO(){}
//
//   public UserInfoDTO(Integer userId, Long username, Long phoneNumber, Long location){
//        this.userId = userId;
//        this.username = username.toString();
//        this.phoneNumber = phoneNumber.toString();
//        this.location = location.toString();
//
//   }



}
