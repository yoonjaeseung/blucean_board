package com.example.board.domain.dto;

import com.example.board.common.dto.DtoBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class UserAccountDto extends DtoBase {
    private String accountEmail;
    private String accountPassword;
    private String birthDay;
    private String sexCode;
    private String openScopeCode;
    private String countryCode;
    private String joinDivisionCode;
    private String userName;
    private Date firstPracticeDatetime;
    private Date lastPracticeDatetime;
    private int code;


}
