package com.avengers.musinsa.domain.user.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String role;
    private String name;
    private String username;
    private String gender;
    private String birthday;
    private Integer birthyear;
    private String phone;

}
