package com.example.board.domain.repository;

import com.example.board.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository<T, ID>
 * CrudRepository<T, ID>
 * PagingAndSortingRepository<T, ID>
 * JpaRepository<T, ID>
 * T는 Entity의 타입클래스이고 ID는 P.K 값의 Type 이다.
 */

/**
 * Q.UserRepository 인데 JpaRepository 에서는 UserAccount 를 받아오네요?
 *  네이밍이랑 동일한 entity를 가져와야 하지 않을까요??
 * A. 엔티티 하나당 저장소도 하나인가요??
 *
 * Q.그리고 JpaRepository 에서 String 은 왜 String 이죠???
 * A. <엔티티, pk 타입> 인데 제가 잘 못 적었습니다.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     findAll 은 jpa에서 제공 해 주지 않나요??
     그렇다면 어떻게 작성해야 할까요?
     */
    List<User> findAll();

}
