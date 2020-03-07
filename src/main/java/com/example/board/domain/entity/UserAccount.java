package com.example.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Spring Data JPA 방식
 *
 * @Column(name = "account_email"
 * 컬럼을 이렇게 지정 하면 저장이 가능한가요??
 * <p>
 * ddl 에 컬럼 명이 "account_email" 이렇게 생성 되어 있나요??
 * 저는 아래와 같은 에러가 나는 군요.
 * JdbcSQLSyntaxErrorException: Column "ACCOUNT_EMAIL" not found; SQL statement:
 * insert into tb_user_account (id, account_email, account_password, birth_day, country_code, create_datetime, create_host, first_practice_datetime, join_division_code, last_practice_datetime, open_scope_code, sex_code, update_datetime, update_host, user_name) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
 */

@Entity
@Table(name = "tb_user_account" , schema = "test")
@Getter
@Setter
@AllArgsConstructor // 모든필드를 파라미터로 입력받은 생성자
@NoArgsConstructor  // 파라미터가 없는 생성자 => 기본생성자
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "accountEmail", nullable = false)
    private String accountEmail;

    @Column(name = "accountPassword", nullable = false)
    private String accountPassword;

    @Column(name = "birthDay", nullable = true)
    private String birthDay;

    @Column(name = "sexCode", nullable = true)
    private String sexCode;

    @Column(name = "openScopeCode", nullable = true)
    private String openScopeCode;

    @Column(name = "countryCode", nullable = true)
    private String countryCode;

    @Column(name = "joinDivisionCode", nullable = true)
    private String joinDivisionCode;

    @Column(name = "userName", nullable = true)
    private String userName;

    @Column(name = "firstPracticeDatetime", nullable = true)
    private Date firstPracticeDatetime;

    @Column(name = "lastPracticeDatetime", nullable = true)
    private Date lastPracticeDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDatetime", nullable = false)
    private Date createDatetime;

    @Column(name = "createHost", nullable = false)
    private String createHost;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateDatetime", nullable = false)
    private Date updateDatetime;

    @Column(name = "updateHost", nullable = false)
    private String updateHost;
}
