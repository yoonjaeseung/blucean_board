package com.example.board.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "tb_user_account")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccount extends EmBaseEntity implements Serializable {

    @Column(name = "accountEmail", nullable = false, length = 80)
    private String accountEmail;

    @Column(name = "accountPassword", length = 80)
    private String accountPassword;

    @Column(name = "birthday", length = 8)
    private String birthday;

    @Column(name = "sexCode", length = 1)
    private String sexCode;

    @Column(name = "openScopeCode", length = 1)
    private String openScopeCode;

    @Column(name = "countryCode", length = 10)
    private String countryCode;

    @Column(name = "joinDivisionCode", length = 2)
    private String joinDivisionCode;

    @Column(name = "userName", length = 60)
    private String userName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "firstPracticeDatetime")
    private Date firstPracticeDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastPracticeDatetime")
    private Date lastPracticeDatetime;

    @Builder
    public UserAccount(String accountEmail, String accountPassword, String birthday, String sexCode, String openScopeCode,
                       String countryCode, String joinDivisionCode, String userName, Date firstPracticeDatetime, Date lastPracticeDatetime) {
        this.accountEmail = accountEmail;
        this.accountPassword = accountPassword;
        this.birthday = birthday;
        this.sexCode = sexCode;
        this.openScopeCode = openScopeCode;
        this.countryCode = countryCode;
        this.joinDivisionCode = joinDivisionCode;
        this.userName = userName;
        this.firstPracticeDatetime = firstPracticeDatetime;
        this.lastPracticeDatetime = lastPracticeDatetime;
    }
}
