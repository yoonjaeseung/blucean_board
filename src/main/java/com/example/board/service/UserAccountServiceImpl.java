package com.example.board.service;

import com.example.board.domain.entity.UserAccount;
import com.example.board.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    //Read All UserAccount
    @Override
    public List<UserAccount> allUserAccount() {
        return userAccountRepository.findAll();
    }

    //Read One userAccount
    @Override
    public List<UserAccount> userAccountEmail(String accountEmail) {
        return userAccountRepository.findByAccountEmail(accountEmail);
    }

    //Create userAccount
    @Override
    public void createUserAccount(Long id, String accountEmail, String accountPassword, String birthDay, String sexCode, String openScopeCode,
                                  String countryCode, String joinDivisionCode, String userName, Date firstPracticeDatetime, Date lastPracticeDatetime, Date createDatetime,
                                  String createHost, Date updateDatetime, String updateHost) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(id);
        userAccount.setAccountEmail(accountEmail);
        userAccount.setAccountPassword(accountPassword);
        userAccount.setBirthday(birthDay);
        userAccount.setSexCode(sexCode);
        userAccount.setOpenScopeCode(openScopeCode);
        userAccount.setCountryCode(countryCode);
        userAccount.setJoinDivisionCode(joinDivisionCode);
        userAccount.setUserName(userName);
        userAccount.setFirstPracticeDatetime(firstPracticeDatetime);
        userAccount.setLastPracticeDatetime(lastPracticeDatetime);
        userAccount.setCreateDatetime(createDatetime);
        userAccount.setCreateHost(createHost);
        userAccount.setUpdateDatetime(updateDatetime);
        userAccount.setUpdateHost(updateHost);
        userAccountRepository.save(userAccount);
    }

    //Update userAccount
    @Override
    public void updateUserAccount(Long id, String accountPassword) {
        //id로 db find
        UserAccount updateUserAccountDB = userAccountRepository.findById(id).orElseGet(null);
        updateUserAccountDB.setAccountPassword(accountPassword);
        userAccountRepository.save(updateUserAccountDB);

    }

    //Delete userAccount
    @Override
    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }

}

