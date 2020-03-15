package com.example.board.controller;


import com.example.board.domain.dto.SysQnaDto;
import com.example.board.domain.entity.SysQna;
import com.example.board.service.SysQnaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController // @Controller + @ResponseBody
@RequestMapping("/board")
public class SysQnaController {
    private SysQnaService sysQnaService;

    @Autowired
    public SysQnaController(SysQnaService sysQnaService) {
        this.sysQnaService = sysQnaService;
    }

    // json을 view에 객체롤 넘겨줘야하는데 어떻게 넘겨줄지 잘 모르겠습니다.
    // 모든 리스트를 가져와서 @RequestBody는 필요없다고 생각했습니다.
    // allBoardList에 결과값을 저장 후 model에 저장하여 view에서 사용해야 된다고 생각하는데,
    // 그 방법을 모르겠습니다.
    // 밑에 주석을 실행하면 요청 url에 json형식으로 모든 데이터를 불러옵니다.

    @GetMapping("/boardList")
    public @ResponseBody
    List<SysQna> allBoardList(Model model) {
        List<SysQna> allBoardList = sysQnaService.allBoardList();
        model.addAttribute("allBoardList", allBoardList);
        return allBoardList;
    }


    //데이터와 뷰의 정보를 함께 전달하기 위해 ModelAndView를 사용해봤습니다.
    //밑에 주석을 실행하면 게시판 형태로 출력됩니다.
/*    @GetMapping("/boardList")
    public @ResponseBody
    ModelAndView allBoardList(ModelAndView mav) {
        List<SysQna> allBoardList = sysQnaService.allBoardList();
        mav.addObject("allBoardList", allBoardList);
        mav.setViewName("board/boardList");
        return mav;
    }*/

    @PostMapping("/boardWrite")
    public @ResponseBody
    SysQnaDto createBoardWrite(@RequestBody SysQnaDto sysQnaDto) {
        log.info("createBoardWrite===={}", sysQnaDto);
        return sysQnaService.create(sysQnaDto);
    }
}

