package com.example.board.controller;

import com.example.board.domain.dto.UserAccountDto;
import com.example.board.domain.entity.UserAccount;
import com.example.board.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class UserInfoController {
    //    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    private UserAccountService userAccountService;

    @Autowired
    public UserInfoController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/userList")
    public String allUserAccountList(Model model) {
        List<UserAccount> userAccountList = userAccountService.allUserAccountList();
        model.addAttribute("userAccountList", userAccountList);
        return "user/userList";
    }

    @PostMapping("/userList/userSearch")
    public String userAccountSearch(@RequestParam(value = "accountEmail") String accountEmail, Model model) {
        log.info("userAccountEmail search =={}", accountEmail);
        List<UserAccount> userAccountSearch = userAccountService.userAccountSearch(accountEmail);
        model.addAttribute("userAccountSearch", userAccountSearch);
        return "user/userSearch";
    }

    //회원가입
    @PostMapping("/userJoin")
    public String userAccountInsert(UserAccountDto userAccountDto, Model model) {
        UserAccountDto req = userAccountService.userAccountCreate(userAccountDto);
        model.addAttribute(req);
        return "redirect:userJoinSuccess";
    }

    @GetMapping("/userList/userUpdate")
    public String userAccountUpdateView() {
        return "user/userUpdate";
    }

    @PostMapping("/userList/userUpdate")
    public String userAccountUpdate(Long id, String accountPassword, String openScopeCode, String countryCode) {
        log.info("userAccountUpdate=={}", id);
        userAccountService.userAccountUpdate(id, accountPassword, openScopeCode, countryCode);
        return "redirect:/userList";
    }

    @GetMapping("/userList/userDelete")
    public String userAccountDelete(Long id) {
        userAccountService.userAccountDelete(id);
        return "redirect:/userList";
    }

}
