package com.example.board.domain.entity;

import com.example.board.common.entitiy.EmBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user_phone_number")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPhone extends EmBaseEntity implements Serializable {

    @Column(name = "userPhoneNumber", nullable = false, length = 20)
    private String userPhoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "firstPracticeDatetime")
    private Date firstPracticeDatetime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastPracticeDatetime")
    private Date lastPracticeDatetime;

    @Builder
    public UserPhone(String userPhoneNumber, Date firstPracticeDatetime, Date lastPracticeDatetime) {
        this.userPhoneNumber = userPhoneNumber;
        this.firstPracticeDatetime = firstPracticeDatetime;
        this.lastPracticeDatetime = lastPracticeDatetime;
    }
}
