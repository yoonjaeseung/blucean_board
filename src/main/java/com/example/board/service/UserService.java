package com.example.board.service;

import com.example.board.domain.entity.User;

import java.util.List;
/**
 userService 인데 userAccount 를 조회 하는게 맞을까요??
 네이밍을 한번 고려해 보세요.
 */
public interface UserService {
    
    //모든회원 리스트
    List<User> getAllUser();

    //회원가입 시
//    UserEntityTest setUser(UserEntityTest userEntityTest);

}
