package com.example.board.service;

import com.example.board.domain.entity.UserAccount;
import com.example.board.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    //전체회원 조회
    @Override
    public List<UserAccount> allUserAccount() {
        return userAccountRepository.findAll();
    }

    //특정회원 조회(account_email)
    @Override
    public List<UserAccount> userAccountEmail(String accountEmail) {
        return userAccountRepository.findByAccountEmail(accountEmail);
    }
    //특정회원 삭제
    @Override
    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }
}

