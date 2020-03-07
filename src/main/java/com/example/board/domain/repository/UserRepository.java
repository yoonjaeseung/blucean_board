package com.example.board.domain.repository;

import com.example.board.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 회원 Repository
 *
 * */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
