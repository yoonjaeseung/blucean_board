package com.example.board.service;

import com.example.board.domain.dto.SysQnaDto;
import com.example.board.domain.entity.SysQna;
import com.example.board.domain.repository.SysQnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysQnaServiceImpl implements SysQnaService {

    private SysQnaRepository sysQnaRepository;

    @Autowired
    public SysQnaServiceImpl(SysQnaRepository sysQnaRepository) {
        this.sysQnaRepository = sysQnaRepository;
    }

    @Override
    public List<SysQna> allBoardList() {
        return sysQnaRepository.findAll();
    }

    @Override
    public SysQnaDto create(SysQnaDto sysQnaDto) {

        SysQna sysQna = SysQna.builder()
                .accountEmail(sysQnaDto.getAccountEmail())
                .userPhoneNumber(sysQnaDto.getUserPhoneNumber())
                .questionContent(sysQnaDto.getQuestionContent())
                .build();
        sysQnaRepository.save(sysQna);
        SysQnaDto res = new SysQnaDto();
        res.setCode(200);
        res.setQnaTypeCode("4");

        return res;
    }
}
