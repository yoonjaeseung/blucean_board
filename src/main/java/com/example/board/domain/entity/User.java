package com.example.board.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends EmBaseEntity implements Serializable {

    @Column(name = "accountId", nullable = false, length = 80)
    private Long accountId;

    @Column(name = "phoneNumberId", nullable = false)
    private Long phoneNumberId;

    @Column(name = "activeFlag", nullable = false, length = 1)
    private String activeFlag;

    @Column(name = "lastPracticeDatetime")
    private Date lastPracticeDatetime;

    @Column(name = "telecomName", length = 100)
    private String telecomName;

    @Builder
    public User(Long accountId, Long phoneNumberId, String activeFlag, Date lastPracticeDatetime, String telecomName) {
        this.accountId = accountId;
        this.phoneNumberId = phoneNumberId;
        this.activeFlag = activeFlag;
        this.lastPracticeDatetime = lastPracticeDatetime;
        this.telecomName = telecomName;
    }
}
