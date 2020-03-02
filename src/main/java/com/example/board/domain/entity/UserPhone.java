package com.example.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user_phone_number", schema = "test")
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userPhoneNumber;

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
