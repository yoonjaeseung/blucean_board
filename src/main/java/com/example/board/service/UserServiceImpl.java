package com.example.board.service;

import com.example.board.domain.entity.User;
import com.example.board.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
/**
 Controller 에서 @Autowied 랑 왜 다르게 한건가요??
 전에 알려준 필드주입, 생성자 주입 다시 한번 봐보세요
 */
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

//    @Override
//    public UserEntityTest setUser(UserEntityTest userEntityTest) {
//        return userRepository.save(User);
//    }

}
