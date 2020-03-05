package com.example.board.service;

import com.example.board.domain.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> allUserAccount();

    List<UserAccount> userAccountEmail(String accountEmail);

    void updateUserAccount(UserAccount userAccount, Long id, String accountPassword);

    void deleteUserAccount(Long id);

}
