package com.example.board.controller;

import com.example.board.domain.entity.User;
import com.example.board.domain.entity.UserAccount;
import com.example.board.domain.entity.UserTest;
import com.example.board.domain.repository.UserAccountRepository;
import com.example.board.service.UserAccountService;
import com.example.board.service.UserService;
import com.example.board.service.UserTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    private final UserService userService;
    private final UserAccountService userAccountService;
    private final UserTestService userTestService;

    @Autowired
    public UserController(UserService userService, UserAccountService userAccountService, UserTestService userTestService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.userTestService = userTestService;
    }

    @GetMapping("/userList")
    public String allUserAccountList(Model model) {
        List<UserAccount> allUserAccount = userAccountService.allUserAccount();

        model.addAttribute("allUserAccount", allUserAccount);

        return "user/userList";
    }

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

    //userTest 계정 생성
//    @GetMapping("/userJoinForm")
//    public String JoinUserAccount() {
//        return "user/userJoinForm";
//    }
//
//    @PostMapping("/userJoinForm")
//    public String JoinUserAccount(UserTest userTest, Model model) {
//        List<UserTest> joinUser = userTestService.joinUserAccount(userTest);
//
//        model.addAttribute(joinUser);
//        return "user/userJoinSuccess";
//    }
    @GetMapping("/userJoin")
    public String createUserAccountForm() {
        return "user/userJoin";
    }

    @PostMapping("/userJoin")
    public String createUserAccount(Long id, String accountEmail, String accountPassword, String birthDay, String sexCode, String openScopeCode,
                                    String countryCode, String joinDivisionCode, String userName, Date firstPracticeDatetime, Date lastPracticeDatetime, Date createDatetime,
                                    String createHost, Date updateDatetime, String updateHost) {
        userAccountService.createUserAccount(id, accountEmail, accountPassword, birthDay, sexCode, openScopeCode, countryCode, joinDivisionCode, userName, firstPracticeDatetime,
                lastPracticeDatetime, createDatetime, createHost, updateDatetime, updateHost);
        return "user/userJoinSuccess";
    }


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

    @GetMapping("/userDelete")
    public String deleteUserAccount(Long id) throws Exception {
        userAccountService.deleteUserAccount(id);
        log.info("===delete==={}", id);
        return "redirect:/userView";
    }

}
