package com.example.board.service;

import com.example.board.domain.dto.UserAccountDto;
import com.example.board.domain.entity.UserAccount;
import com.example.board.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public List<UserAccount> allUserAccountList() {
        return userAccountRepository.findAll();
    }

    @Override
    public List<UserAccount> userAccountSearch(String accountEmail) {
        return userAccountRepository.findByAccountEmail(accountEmail);
    }

    @Override
    public UserAccountDto userAccountCreate(UserAccountDto userAccountDto) {
        UserAccount userAccount = UserAccount.builder()
                .accountEmail(userAccountDto.getAccountEmail())
                .accountPassword(userAccountDto.getAccountPassword())
                .birthday(userAccountDto.getBirthDay())
                .sexCode(userAccountDto.getSexCode())
                .openScopeCode(userAccountDto.getOpenScopeCode())
                .countryCode(userAccountDto.getCountryCode())
                .joinDivisionCode(userAccountDto.getJoinDivisionCode())
                .userName(userAccountDto.getUserName())
                .firstPracticeDatetime(userAccountDto.getFirstPracticeDatetime())
                .lastPracticeDatetime(userAccountDto.getLastPracticeDatetime())
                .build();
        userAccountRepository.save(userAccount);
        UserAccountDto res = new UserAccountDto();
        res.setCode(200);
        return res;
    }

    @Override
    public void userAccountUpdate(Long id, String accountPassword, String openScopeCode, String countryCode) {
        UserAccount userAccount = userAccountRepository.findById(id).orElse(null);
        userAccount.setAccountPassword(accountPassword);
        userAccount.setOpenScopeCode(openScopeCode);
        userAccount.setCountryCode(countryCode);
        userAccountRepository.save(userAccount);
    }

    @Override
    public void userAccountDelete(Long id) {
        userAccountRepository.deleteById(id);
    }
}
