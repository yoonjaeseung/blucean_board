package com.example.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_user_account", schema = "test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_email", nullable = false)
    private String accountEmail;

    @Column(name = "account_password", nullable = true)
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
    private java.util.Date firstPracticeDatetime;

    @Column(name = "last_practice_datetime", nullable = true)
    private java.util.Date lastPracticeDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_datetime", nullable = false)
    private java.util.Date createDatetime;

    @Column(name = "create_host", nullable = false)
    private String createHost;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_datetime", nullable = false)
    private java.util.Date updateDatetime;

    @Column(name = "update_host", nullable = false)
    private String updateHost;


}
