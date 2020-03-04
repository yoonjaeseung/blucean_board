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

import java.util.List;
@Slf4j
@Controller
public class UserController {

    private final UserService userService;
    private final UserAccountService userAccountService;

    @Autowired
    public UserController(UserService userService, UserAccountService userAccountService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/userList")
    public String allUserAccount(String accountEmail, Model model) {
        List<UserAccount> allUserAccount = userAccountService.allUserAccount();

        model.addAttribute("allUserAccount", allUserAccount);

        return "user/userList";
    }

    @GetMapping("/userView")
    public String userAccountEmail(){
        return "user/userView";
    }

    @PostMapping("/userView")
    public String userAccountEmail(String accountEmail, Model model){
        List<UserAccount> userAccountEmail = userAccountService.userAccountEmail(accountEmail);
        model.addAttribute("userAccountEmail",userAccountEmail);
        log.info("View -> Controller = {}", userAccountEmail);
        return "user/userView";
    }

    @GetMapping("/userDelete")
    public String deleteUserAccount(Long id) throws Exception{
       userAccountService.deleteUserAccount(id);
        log.info("===delete==={}", id);
        return "user/userView";
    }

}
