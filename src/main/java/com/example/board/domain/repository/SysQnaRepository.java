package com.example.board.domain.repository;

import com.example.board.domain.entity.SysQna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysQnaRepository extends JpaRepository<SysQna, Long> {

}
