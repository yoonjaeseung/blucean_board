package com.example.board.service;

import com.example.board.domain.dto.UserAccountDto;
import com.example.board.domain.entity.UserAccount;

import java.util.List;

public interface UserAccountService {
    List<UserAccount> allUserAccountList();

    List<UserAccount> userAccountSearch(String accountEmail);

    UserAccountDto userAccountCreate(UserAccountDto userAccountDto);

    void userAccountUpdate(Long id, String accountPassword, String openScopeCode, String countryCode);

    void userAccountDelete(Long id);

}
