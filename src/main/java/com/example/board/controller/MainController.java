package com.example.board.controller;

import com.example.board.domain.entity.UserAccount;
import com.example.board.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private JdbcTemplate jdbcTemplate;


    // 메인 페이지
    @GetMapping("/")
    public String main(Locale locale, Model model) {
        logger.info("The client locale is {}", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "main";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String LoginForm() {
        return "login";
    }


    //DB Test
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //DB Test
    @GetMapping("/mariaTest")
    public List<String> tbUserAccount() {
        return jdbcTemplate.queryForList("select accountEmail from test.tb_user_account order by id", String.class);
    }


}


