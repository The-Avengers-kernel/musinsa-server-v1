package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.user.dto.MyPageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyPageMapper {
    MyPageDto findUserProfileId(@Param("userId") Long userId);
    MyPageDto findUserProfileByUserName(@Param("username") String username); 
}
