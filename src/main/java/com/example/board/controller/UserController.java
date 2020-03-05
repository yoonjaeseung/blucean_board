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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String allUserAccount(Model model) {
        List<UserAccount> allUserAccount = userAccountService.allUserAccount();

        model.addAttribute("allUserAccount", allUserAccount);

        return "user/userList";
    }

    @GetMapping("/userView")
    public String userAccountEmail() {
        return "user/userView";
    }

    @PostMapping("/userView")
    public String userAccountEmail(String accountEmail, Model model) {
        List<UserAccount> userAccountEmail = userAccountService.userAccountEmail(accountEmail);
        model.addAttribute("userAccountEmail", userAccountEmail);
        log.info("View -> Controller = {}", userAccountEmail);
        return "user/userView";
    }

    //userTest 계정 생성
    @GetMapping("/userJoinForm")
    public String JoinUserAccount() {
        return "user/userJoinForm";
    }

    @PostMapping("/userJoinForm")
    public String JoinUserAccount(UserTest userTest, Model model) {
        List<UserTest> joinUser = userTestService.joinUserAccount(userTest);

        model.addAttribute(joinUser);
        return "user/userJoinSuccess";
    }


    @GetMapping("/userDelete")
    public String deleteUserAccount(Long id) throws Exception {
        userAccountService.deleteUserAccount(id);
        log.info("===delete==={}", id);
        return "redirect:/userView";
    }

    @GetMapping("/userUpdate")
    public String userAccountUpdate() {
        return "user/userUpdate";
    }
    /**
     *
     * 이부분이 update 관련 controller 입니다
     *
     * */
    @PostMapping("/userUpdate")
    public String update(UserAccount userAccount, String accountPassword, Long id, Model model) {
        userAccountService.updateUserAccount(userAccount, id, accountPassword);
//        model.addAttribute("id", id);
//        model.addAttribute("accountPassword", accountPassword);
        log.info("===update password==={}", accountPassword);
        return "redirect:/userView";

    }

}
