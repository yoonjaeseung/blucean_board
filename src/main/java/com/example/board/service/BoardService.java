package com.example.board.service;

import com.example.board.domain.dto.SysQnaDto;
import com.example.board.domain.entity.EmSysQna;

import java.util.List;

public interface BoardService {

    List<EmSysQna> testQnaSelectAll();

    //게시글 이메일 또는 전화번호로 검색
    List<EmSysQna> testQnaSelect(String accountEmail, String userPhoneNumber);

    List<EmSysQna> testQnaFindAccountEmail(String accountEmail);
    List<EmSysQna> testQnaFindUserPhoneNumber(String UserPhoneNumber);


    //게시글 작성(계정, 번호, 내용)
    SysQnaDto testQnaInsert(SysQnaDto sysQnaDto);

    //게시글 상세조회(id로 찾기)
    EmSysQna testQnaUpdateView(SysQnaDto sysQnaDto);
    EmSysQna testQnaFindId(Long id);

    //게시글 수정
    SysQnaDto testQnaUpdate(SysQnaDto sysQnaDto);

    //게시글 삭제
    SysQnaDto testQnaDelete(SysQnaDto sysQnaDto);
}
