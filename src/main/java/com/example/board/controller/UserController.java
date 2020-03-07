package com.example.board.controller;

import com.example.board.domain.entity.UserAccount;
import com.example.board.service.UserAccountService;
import com.example.board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }


    // 모든 회원 정보 가져오기
    @GetMapping("/userList")
    public String allUserAccountList(Model model) {
        List<UserAccount> allUserAccount = userAccountService.allUserAccount();
        model.addAttribute("allUserAccount", allUserAccount);
        return "user/userList";
    }


    // 회원 찾기
    @GetMapping("/userView")
    public String userAccountEmailForm() {
        return "user/userView";
    }

    @PostMapping("/userView")
    public String userAccountEmail(@RequestParam("accountEmail") String accountEmail, Model model) {
        List<UserAccount> userAccount = userAccountService.userAccountEmail(accountEmail);
        model.addAttribute("userAccount", userAccount);
        log.info("View -> Controller = {}", userAccount);
        return "user/userView";
    }


    // 회원 가입
    @GetMapping("/userJoin")
    public String createUserAccountForm() {
        return "user/userJoin";
    }

    @PostMapping("/userJoin")
    public String createUserAccount(Long id, String accountEmail, String accountPassword, String birthDay, String sexCode, String openScopeCode,
                                    String countryCode, String joinDivisionCode, String userName, Date firstPracticeDatetime, Date lastPracticeDatetime, Timestamp createDatetime, String createHost,
                                    Timestamp updateDatetime, String updateHost) {
        userAccountService.createUserAccount(id, accountEmail, accountPassword, birthDay, sexCode, openScopeCode, countryCode, joinDivisionCode, userName, firstPracticeDatetime,
                lastPracticeDatetime, createDatetime, createHost, updateDatetime, updateHost);

        return "user/userJoinSuccess";
    }


    // 특정 회원 암호 수정
    @GetMapping("/userUpdate")
    public String updateUserAccountForm() {
        return "user/userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUserAccount(String accountPassword, Long id) {
        userAccountService.updateUserAccount(id, accountPassword);
        log.info("===update password==={}", accountPassword);
        return "redirect:/userView";

    }


    // 회원 삭제
    @GetMapping("/userDelete")
    public String deleteUserAccount(Long id) throws Exception {
        userAccountService.deleteUserAccount(id);
        log.info("===delete==={}", id);
        return "redirect:/userView";
    }

}
