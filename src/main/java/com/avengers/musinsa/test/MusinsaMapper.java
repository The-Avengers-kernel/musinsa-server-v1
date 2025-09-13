//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.avengers.musinsa.test;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusinsaMapper {
    List<TestUser> findAllUsers();

    TestUser findUserById(Long id);

    void insertUser(TestUser user);
}
