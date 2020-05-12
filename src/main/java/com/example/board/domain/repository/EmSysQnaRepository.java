package com.example.board.domain.repository;

import com.example.board.domain.entity.EmSysQna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmSysQnaRepository extends JpaRepository<EmSysQna, Long> {

    //게시글 이메일 또는 전화번호 검색
    List<EmSysQna> findByAccountEmailOrUserPhoneNumber(String accountEmail, String userPhoneNumber);

    List<EmSysQna> findByAccountEmail(String accountEmail);
    List<EmSysQna> findByUserPhoneNumber(String userPhoneNumber);



    //게시글 상세조회(id로 찾기)
    Optional<EmSysQna> findById(Long id);


}
