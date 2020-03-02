package com.example.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_user_account", schema = "test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String accountEmail;

    @Column(nullable = true)
    private String accountPassword;

    @Column(nullable = true)
    private String birthday;

    @Column(nullable = true)
    private String sexCode;

    @Column(nullable = true)
    private String openScopeCode;

    @Column(nullable = true)
    private String countryCode;

    @Column(nullable = true)
    private String joinDivisionCode;

    @Column(nullable = true)
    private String userName;

    @Column(nullable = true)
    private Date firstPracticeDatetime;

    @Column(nullable = true)
    private Date lastPracticeDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private java.util.Date createDatetime;

    @Column(nullable = false)
    private String createHost;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private java.util.Date updateDatetime;

    @Column(nullable = false)
    private String updateHost;




}
