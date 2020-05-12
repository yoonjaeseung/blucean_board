package com.example.board.domain.entity;

import com.example.board.common.entitiy.EmBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Spring Data JPA 방식
 */

@Entity
@Table(name = "tb_user_account", schema = "test")
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
