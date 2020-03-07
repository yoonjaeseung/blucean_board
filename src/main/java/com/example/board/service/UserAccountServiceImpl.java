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
 * <p>
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

    /**
     * firstPracticeDatetime, lastPracticeDatetime 는 현재 우리 프로젝트에서 중요하게 사용 하는 필드 입니다.
     * 현재 게시판 프로젝트에서는 필요 없을수 있겠지만, 필수로 알아둬야 업무에 도움이 될 겁니다.
     * <p>
     * firstPracticeDatetime,lastPracticeDatetime,createDatetime,createHost,updateDatetime,updateHos 의 경우 내부에서
     * 사용 하는 필드 입니다. jsp에서 부터 넘어오지 않고, service 로직 내에서 적용 가능 합니다.
     * <p>
     * Timestamp.valueOf(LocalDateTime.now()) 으로도 사용 할수 있지만, 현재 시간을 넣는 방법은 여러가지가 있으니
     * 사용 하기 편한 것으로 사용 하면 될것 같습니다.
     */
    @Override
    public void createUserAccount(Long id, String accountEmail, String accountPassword, String birthDay,
                                  String sexCode, String openScopeCode, String countryCode, String joinDivisionCode,
                                  String userName) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(id);
        userAccount.setAccountEmail(accountEmail);
        userAccount.setAccountPassword(accountPassword);
        userAccount.setBirthDay(birthDay);
        userAccount.setSexCode(sexCode);
        userAccount.setOpenScopeCode(openScopeCode);
        userAccount.setCountryCode(countryCode);
        userAccount.setJoinDivisionCode(joinDivisionCode);
        userAccount.setUserName(userName);
        userAccount.setFirstPracticeDatetime(new Date());
        userAccount.setLastPracticeDatetime(new Date());
        userAccount.setCreateDatetime(Timestamp.valueOf(LocalDateTime.now()));
        userAccount.setCreateHost("yoonjs");
        userAccount.setUpdateDatetime(Timestamp.valueOf(LocalDateTime.now()));
        userAccount.setUpdateHost("yoonjs");
        userAccountRepository.save(userAccount);
    }

    // 특정 회원 암호 수정
    // optional 을 사용하여 null 발생 시 NullPointException 에러를 방어하기 위해 orElseGet(other: null 값이 있을 경우만 실행) 을 사용했습니다.
    @Override
    public void updateUserAccount(Long id, String accountPassword) {
        //id로 db find
        UserAccount updateUserAccountDB = userAccountRepository.findById(id).orElseGet(null);
        updateUserAccountDB.setAccountPassword(accountPassword);
        updateUserAccountDB.setLastPracticeDatetime(new Date()); // 최근실행 했다고 가정
        updateUserAccountDB.setUpdateDatetime(new Date()); // 가입 후 정보 수정일시
        userAccountRepository.save(updateUserAccountDB);

    }

    // 특정회원 삭제
    @Override
    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }

}

