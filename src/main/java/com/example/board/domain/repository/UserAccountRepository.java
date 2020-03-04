package com.example.board.domain.repository;

import com.example.board.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    List<UserAccount> findByAccountEmail(String accountEmail);

    void deleteById(Long id);

}
