package com.example.board.service;

import com.example.board.domain.dto.SysQnaDto;
import com.example.board.domain.entity.EmSysQna;
import com.example.board.domain.repository.EmSysQnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private EmSysQnaRepository emSysQnaRepository;

    @Autowired
    public BoardServiceImpl(EmSysQnaRepository emSysQnaRepository) {
        this.emSysQnaRepository = emSysQnaRepository;
    }
    //게시글 전체
    @Override
    public List<EmSysQna> testQnaSelectAll() {
        return emSysQnaRepository.findAll();
    }

    //게시글 이메일 또는 전화번호로 검색
    @Override
    public List<EmSysQna> testQnaSelect(String accountEmail, String userPhoneNumber) {
        return emSysQnaRepository.findByAccountEmailOrUserPhoneNumber(accountEmail, userPhoneNumber);
    }

    @Override
    public List<EmSysQna> testQnaFindAccountEmail(String accountEmail) {
        return emSysQnaRepository.findByAccountEmail(accountEmail);
    }

    @Override
    public List<EmSysQna> testQnaFindUserPhoneNumber(String UserPhoneNumber) {
        return emSysQnaRepository.findByUserPhoneNumber(UserPhoneNumber);
    }

    //게시글 작성(계정, 번호, 내용)
    @Override
    public SysQnaDto testQnaInsert(SysQnaDto sysQnaDto) {
        EmSysQna emSysQna = EmSysQna.builder()
                .accountEmail(sysQnaDto.getAccountEmail())
                .userPhoneNumber(sysQnaDto.getUserPhoneNumber())
                .questionContent(sysQnaDto.getQuestionContent())
                .replyEmailAddress("test@gmail.com")
                .replyEmailFlag("N")
                .replyFlag("N")
                .build();
        emSysQnaRepository.save(emSysQna);
        SysQnaDto res = new SysQnaDto();
        res.setCode(200);
        return res;
    }

    //게시글 상세조회 - dto 사용
    @Override
    public EmSysQna testQnaUpdateView(SysQnaDto testDto) {
        return emSysQnaRepository.findById(testDto.getId()).orElse(null);
    }
    //게시글 상세조회(id로 찾기)
    @Override
    public EmSysQna testQnaFindId(Long id) {
        return emSysQnaRepository.findById(id).orElse(null);
    }

    //게시글 수정
    @Override
    public SysQnaDto testQnaUpdate(SysQnaDto testDto) {
        EmSysQna emSysQna = emSysQnaRepository.findById(testDto.getId()).orElse(null);
        emSysQna.setQuestionContent(testDto.getQuestionContent());
        emSysQnaRepository.save(emSysQna);

        SysQnaDto res = new SysQnaDto();
        res.setCode(200);
        return res;
    }

    //게시글 삭제
    @Override
    public SysQnaDto testQnaDelete(SysQnaDto testDto) {
        emSysQnaRepository.deleteById(testDto.getId());
        SysQnaDto res = new SysQnaDto();
        res.setCode(200);
        return res;
    }
}
