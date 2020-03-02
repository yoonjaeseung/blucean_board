package com.example.board.controller;

import com.example.board.domain.entity.User;
import com.example.board.domain.entity.UserAccount;
import com.example.board.service.UserAccountService;
import com.example.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final UserAccountService userAccountService;

    @Autowired
    public UserController(UserService userService, UserAccountService userAccountService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/list")
    public String AllUserAccountList(Model model) {
        List<UserAccount> userAccountList = userAccountService.getAllUserAccount();
        model.addAttribute("userAccountList", userAccountList);
        return "list";
    }
}
