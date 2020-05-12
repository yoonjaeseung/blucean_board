package com.example.board.controller;

import com.example.board.domain.dto.SysQnaDto;
import com.example.board.domain.entity.EmSysQna;
import com.example.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //게시글 전체목록
    @GetMapping("/boardSelectAll")
    public List<EmSysQna> selectAllBoard() {
        return boardService.testQnaSelectAll();
    }

    //게시글 이메일 또는 전화번호 검색
    @GetMapping("/boardSelect")
    public List<EmSysQna> selectBoardEmailOrPhone(@RequestParam(value = "accountEmail", required = false) String accountEmail,
                                                  @RequestParam(value = "userPhoneNumber", required = false) String userPhoneNumber
    ) {
        log.info("selectBoard email == {}", accountEmail);
        log.info("selectBoard phone == {}", userPhoneNumber);

        if (accountEmail != null) {
            return boardService.testQnaFindAccountEmail(accountEmail);
        } else if(userPhoneNumber != null){
            return boardService.testQnaFindUserPhoneNumber(userPhoneNumber);
        } else{
            return null;
        }
    }

    //게시글 작성(계정, 번호, 내용)
    @PostMapping("/boardInsert")
    public SysQnaDto insertBoard(@Valid @RequestBody SysQnaDto sysQnaDto) {
        return boardService.testQnaInsert(sysQnaDto);
    }

    //게시글 상세 조회(id로 찾기)
//    @GetMapping("/bbs/updateViewBoard")
//    public EmSysQna updateViewBoard(TestDto testDto) {
//        log.info("updateViewBoard id={}", testDto.getId());
//        log.info("updateViewBoard ={}", testDto);
//        return bbsService.updateViewBoard(testDto);
//    }

    //게시글 상세 조회(id로 찾기)
    @GetMapping("/boardView")
    public EmSysQna updateViewBoard(@RequestParam(value = "id") Long id) {
        return boardService.testQnaFindId(id);
    }

    //게시글 수정
    @PostMapping("/boardUpdate")
    public SysQnaDto updateBoard(@RequestBody SysQnaDto sysQnaDto) {
        return boardService.testQnaUpdate(sysQnaDto);
    }

    //게시글 삭제
    @PostMapping("/boardDelete")
    public SysQnaDto deleteBoard(@RequestBody SysQnaDto sysQnaDto) {
        return boardService.testQnaDelete(sysQnaDto);
    }
}
