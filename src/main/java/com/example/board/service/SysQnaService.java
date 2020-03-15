package com.example.board.service;

import com.example.board.domain.dto.SysQnaDto;
import com.example.board.domain.entity.SysQna;

import java.util.List;

public interface SysQnaService {

    List<SysQna> allBoardList();
    SysQnaDto create(SysQnaDto sysQnaDto);
}
