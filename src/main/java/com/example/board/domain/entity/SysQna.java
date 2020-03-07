package com.example.board.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_sys_qna")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SysQna extends EmBaseEntity implements Serializable {


    @Column(name = "accountEmail", length = 80)
    private String accountEmail;

    @Column(name = "userPhoneNumber", length = 20)
    private String userPhoneNumber;

    @Column(name = "replyEmailAddress", length = 60)
    private String replyEmailAddress;

    @Column(name = "questionContent", length = 1800)
    private String questionContent;

    @Column(name = "relyFlag", nullable = false, length = 1)
    private String relyFlag;

    @Column(name = "questionTypeCode", length = 3)
    private String questionTypeCode;

    @Column(name = "replyContent", length = 4000)
    private String replyContent;

    @Column(name = "replyId", length = 10)
    private String replyId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "replyDatetime")
    private Date replyDatetime;

    @Column(name = "replyEmailFlag", nullable = false, length = 1)
    private String replyEmailFlag;

    @Column(name = "replyEmailId", length = 10)
    private String replyEmailId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "replyEmailDatetime")
    private Date replyEmailDatetime;

    @Column(name = "qnaTypeCode", length = 1)
    private String qnaTypeCode;

    @Builder
    public SysQna(String accountEmail, String userPhoneNumber, String replyEmailAddress,
                  String questionContent, String questionTypeCode, String replyContent, String replyId, java.util.Date replyDatetime, String replyEmailFlag,
                  String replyEmailId, java.util.Date replyEmailDatetime,
                  String qnaTypeCode) {
        this.accountEmail = accountEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.replyEmailAddress = replyEmailAddress;
        this.questionContent = questionContent;
        this.questionTypeCode = questionTypeCode;
        this.replyContent = replyContent;
        this.replyId = replyId;
        this.replyDatetime = replyDatetime;
        this.replyEmailFlag = replyEmailFlag;
        this.replyEmailId = replyEmailId;
        this.replyEmailDatetime = replyEmailDatetime;
        this.qnaTypeCode = qnaTypeCode;
    }
}
