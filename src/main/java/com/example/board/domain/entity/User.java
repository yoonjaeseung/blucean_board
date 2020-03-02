package com.example.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user", schema = "test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private Long phoneNumberId;

    @Column(nullable = false)
    private String activeFlag;

    @Column(nullable = true)
    private Date lastPracticeDatetime;

    @Column(nullable = true)
    private String telecomName;

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
