package com.example.board.service;

import com.example.board.domain.entity.UserAccount;
import com.example.board.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 회원 계정 Service Implement
 *
 * 회원 계정의 CRUD 기능
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // 모든 회원 List
    @Override
    public List<UserAccount> allUserAccount() {
        return userAccountRepository.findAll();
    }

    // 특정회원 이메일로 찾기
    @Override
    public List<UserAccount> userAccountEmail(String accountEmail) {
        return userAccountRepository.findByAccountEmail(accountEmail);
    }

    // 회원 가입
    // 회원 계정 생성을 위함
    // firstPracticeDatetime(최조실행일시), lastPracticeDatetime(최근실행일시) 의 필요성을 잘 모르겠습니다.
    // 현재 DDL로는 값을 jsp에서 값을 직접 입력해서 넣어줘야 합니다.
    // createDatetime, updateDatetime은 jsp에서 값을 넣지 않아도 자동으로 계정 생성 시 날짜가 입력되게 성공했습니다.
    @Override
    public void createUserAccount(Long id, String accountEmail, String accountPassword, String birthDay,
                                  String sexCode, String openScopeCode, String countryCode, String joinDivisionCode,
                                  String userName, Date firstPracticeDatetime, Date lastPracticeDatetime, Timestamp createDatetime,
                                  String createHost, Timestamp updateDatetime, String updateHost) {
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
        userAccount.setCreateDatetime(Timestamp.valueOf(LocalDateTime.now()));
        userAccount.setCreateHost(createHost);
        userAccount.setUpdateDatetime(Timestamp.valueOf(LocalDateTime.now()));
        userAccount.setUpdateHost(updateHost);
        userAccountRepository.save(userAccount);
    }

    // 특정 회원 암호 수정
    // optional 을 사용하여 null 발생 시 NullPointException 에러를 방어하기 위해 orElseGet(other: null 값이 있을 경우만 실행) 을 사용했습니다.
    @Override
    public void updateUserAccount(Long id, String accountPassword) {
        //id로 db find
        UserAccount updateUserAccountDB = userAccountRepository.findById(id).orElseGet(null);
        updateUserAccountDB.setAccountPassword(accountPassword);
        userAccountRepository.save(updateUserAccountDB);

    }

    // 특정회원 삭제
    @Override
    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }

}

