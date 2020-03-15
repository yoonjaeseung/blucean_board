package com.example.board.common.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DtoBase {

    private Long id;
    private Date createDatetime;
    private Date updateDatetime;
    private String createHost;
    private String updateHost;
}