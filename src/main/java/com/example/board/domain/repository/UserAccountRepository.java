package com.example.board.domain.repository;

import com.example.board.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
/**
 * 회원 계정 Repository
 * */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    // 특정회원 이메일로 찾기
    List<UserAccount> findByAccountEmail(String accountEmail);

    // 특정회원 id로 찾기
    Optional<UserAccount> findById(Long id);

    // 특정회원 삭제
    void deleteById(Long id);

}
