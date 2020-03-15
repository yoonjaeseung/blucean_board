package com.example.board.domain.dto;

import com.example.board.common.dto.DtoBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class SysQnaDto extends DtoBase {

    private String accountEmail;
    private String userPhoneNumber;
    private String replyEmailAddress;
    private String questionContent;
    private String relyFlag;
    private String questionTypeCode;
    private String replyContent;
    private String replyId;
    private Date replyDatetime;
    private String replyEmailFlag;
    private String replyEmailId;
    private Date replyEmailDatetime;
    private String qnaTypeCode;

    private int code;
}
