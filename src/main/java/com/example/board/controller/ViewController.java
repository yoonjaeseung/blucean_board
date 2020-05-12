package com.example.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Controller
public class ViewController {
    // 메인 페이지
    @GetMapping("/")
    public String userMain(Locale locale, Model model) {
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

    // 게시판 목록 화면
    @GetMapping("/boardList")
    public String boardListForm() {
        return "board/boardList";
    }


    //글쓰기
    @GetMapping("/boardWrite")
    public String boardWriteForm() {
        return "board/boardWrite";
    }

//    //글 상세조회
//    @GetMapping("/boardView")
//    public String boardViewForm(){
//        return "board/boardView";
//    }

    // bbsPage
    @GetMapping("/bbs")
    public String bbsPage() {
        return "testPage";
    }

    // 회원가입
    @GetMapping("/userJoin")
    public String userAccountJoin() {
        return "user/userJoin";
    }

//    @GetMapping("/testform")
//    public String test(){
//        return "testform";
//    }
//
//    @PostMapping("/test")
//    public String test(Model model,@RequestParam(value = "id",required = false) String id){
//        log.info("test id=={}",id);
////        model.addAttribute("id", id);
//        return "test";
//    }

//    //DB Test
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    //DB Test
//    @GetMapping("/mariaTest")
//    public List<String> tbUserAccount() {
//        return jdbcTemplate.queryForList("select accountEmail from test.tb_user_account order by id", String.class);
//    }


}
