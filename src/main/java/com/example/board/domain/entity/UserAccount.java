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
    @Column(name = "account_email", nullable = false)
    private String accountEmail;

    @Column(name = "account_password", nullable = false)
    private String accountPassword;

    @Column(name = "birth_day", nullable = true)
    private String birthday;

    @Column(name = "sex_code", nullable = true)
    private String sexCode;

    @Column(name = "open_scope_code", nullable = true)
    private String openScopeCode;

    @Column(name = "country_code", nullable = true)
    private String countryCode;

    @Column(name = "join_division_code", nullable = true)
    private String joinDivisionCode;

    @Column(name = "user_name", nullable = true)
    private String userName;

    @Column(name = "first_practice_datetime", nullable = true)
    private Date firstPracticeDatetime;

    @Column(name = "last_practice_datetime", nullable = true)
    private Date lastPracticeDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_datetime", nullable = false)
    private Date createDatetime;

    @Column(name = "create_host", nullable = false)
    private String createHost;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_datetime", nullable = false)
    private Date updateDatetime;

    @Column(name = "update_host", nullable = false)
    private String updateHost;
}
