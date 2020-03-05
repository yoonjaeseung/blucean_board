package com.example.board.domain.repository;

import com.example.board.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    List<UserAccount> findByAccountEmail(String accountEmail);
//    Optional<UserAccount> findById(Long id);
    void deleteById(Long id);

}
