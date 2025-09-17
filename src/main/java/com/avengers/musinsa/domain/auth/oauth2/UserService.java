package com.avengers.musinsa.domain.auth.oauth2;


import com.avengers.musinsa.domain.user.entity.User;
import com.avengers.musinsa.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public void saveUser(User user) {
        if (user.getUserId() == null) {
            userMapper.insertUser(user);
        } else {
            userMapper.updateUser(user);
        }
    }

    public User findByUserId(Integer userId) {
        return userMapper.findByUserId(userId);
    }
}