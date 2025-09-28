package com.avengers.musinsa.domain.user.service;

import com.avengers.musinsa.domain.user.dto.MyPageDto;
import com.avengers.musinsa.domain.user.repository.MyPageRepository;
import com.avengers.musinsa.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final MyPageRepository myPageRepository;


    public MyPageDto findUserProfileId(Long userId){
        return myPageRepository.findUserProfileId(userId);
    }

    public MyPageDto findUserProfileByUserName(String username){
        return myPageRepository.findUserProfileByUserName(username);
    }



}
