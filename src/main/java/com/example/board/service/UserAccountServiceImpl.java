package com.example.board.service;

import com.example.board.common.entitiy.EmBaseEntity;
import com.example.board.domain.entity.UserAccount;
import com.example.board.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 회원 계정 Service Implement
 * <p>
 * 회원 계정의 CRUD 기능
 */
@Service
public class UserAccountServiceImpl extends EmBaseEntity implements UserAccountService {
    private UserAccountRepository userAccountRepository; // DAO 인스턴스 초기화. 의존 객체 생성

    //@Autowired를 사용하는 경우 아래와 같이 객체의 의존성을 가지는
    //부분에 간단히 애노테이션을 사용하면 쉽게 의존성을 주입 받을 수 있음
    //원래는 xml파일 또는 java class에 Bean설정을 만들어줘야 한다.
    @Autowired
    // 생성자를 통해 UserServiceImpl이 의존하고 있는 UserAccountRepository 객체를 주입 받은 것
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        // 주입 받은 객체를 필드에 할당
        this.userAccountRepository = userAccountRepository;
    }
//    @Autowired가 없을 경우
//    Spring java config에 위 생성자에 있는 파라미터에 메서드를 호출해서 의존 객체를 주입
//    @Bean
//    public UserAccountRepository userAccountRepository(){
//         return new UserAccountRepository();
//    }
//    @Bean
//    public UserAccountServiceImpl userAccountServiceImpl(){
//        return new UserAccountServiceImpl(userAccountRepository());
//    }

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
     * sue : firstPracticeDatetime, lastPracticeDatetime 는 현재 우리 프로젝트에서 중요하게 사용 하는 필드 입니다.
     * 현재 게시판 프로젝트에서는 필요 없을수 있겠지만, 필수로 알아둬야 업무에 도움이 될 겁니다.
     * firstPracticeDatetime,lastPracticeDatetime,createDatetime,createHost,updateDatetime,updateHos 의 경우 내부에서
     * 사용 하는 필드 입니다. jsp에서 부터 넘어오지 않고, service 로직 내에서 적용 가능 합니다.
     * Timestamp.valueOf(LocalDateTime.now()) 으로도 사용 할수 있지만, 현재 시간을 넣는 방법은 여러가지가 있으니
     * 사용 하기 편한 것으로 사용 하면 될것 같습니다.
     */
    @Override
    public void createUserAccount(String accountEmail, String accountPassword, String birthDay,
                                  String sexCode, String openScopeCode, String countryCode, String joinDivisionCode,
                                  String userName) {
        UserAccount userAccount = UserAccount.builder()
                .accountEmail(accountEmail)
                .accountPassword(accountPassword)
                .birthday(birthDay)
                .sexCode(sexCode)
                .openScopeCode(openScopeCode)
                .countryCode(countryCode)
                .joinDivisionCode(joinDivisionCode)
                .userName(userName)
                .build();
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

