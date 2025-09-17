package com.avengers.musinsa.domain.auth.oauth2.repository;

import com.avengers.musinsa.domain.auth.oauth2.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}