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
@Table(name = "tb_sys_qna", schema = "test")
public class SysQna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String accountEmail;

    @Column(nullable = true)
    private String userPhoneNumber;

    @Column(nullable = true)
    private String replyEmailAddress;

    @Column(nullable = true)
    private String questionContent;

    @Column(nullable = false)
    private String relyFlag;

    @Column(nullable = true)
    private String questionTypeCode;

    @Column(nullable = true)
    private String replyContent;

    @Column(nullable = true)
    private String replyId;

    @Column(nullable = true)
    private Date replyDatetime;

    @Column(nullable = false)
    private String replyEmailFlag;

    @Column(nullable = true)
    private String replyEmailId;

    @Column(nullable = true)
    private Date replyEmailDatetime;

    @Column(nullable = true)
    private String qnaTypeCode;

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
