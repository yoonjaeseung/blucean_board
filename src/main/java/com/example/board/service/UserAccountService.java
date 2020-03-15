package com.example.board.service;

import com.example.board.domain.entity.UserAccount;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 회원 계정 Service Interface
 */
public interface UserAccountService {

    //모든 회원 List
    List<UserAccount> allUserAccount();

    // 특정회원 이메일로 찾기
    List<UserAccount> userAccountEmail(String accountEmail);

    // 회원 가입
    void createUserAccount(String accountEmail, String accountPassword, String birthDay, String sexCode, String openScopeCode,
                           String countryCode, String joinDivisionCode, String userName);

    // 특정 회원 암호 수정
    // 회원의 id(일련번호)를 받아와 암호 수정
    void updateUserAccount(Long id, String accountPassword);

    // 특정회원 삭제
    void deleteUserAccount(Long id);
}
