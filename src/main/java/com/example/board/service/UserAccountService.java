package com.example.board.service;

import com.example.board.domain.entity.UserAccount;

import java.util.Date;
import java.util.List;

public interface UserAccountService {

    List<UserAccount> allUserAccount();

    List<UserAccount> userAccountEmail(String accountEmail);

    void createUserAccount(Long id, String accountEmail, String accountPassword, String birthDay, String sexCode, String openScopeCode,
                           String countryCode, String joinDivisionCode, String userName, Date firstPracticeDatetime, Date lastPracticeDatetime, Date createDatetime,
                           String createHost, Date updateDatetime, String updateHost);

    void updateUserAccount(Long id, String accountPassword);

    void deleteUserAccount(Long id);

}
