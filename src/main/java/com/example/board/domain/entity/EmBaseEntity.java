package com.example.board.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
public class EmBaseEntity extends EmBase implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void prepareIdForDto(Long id) {
        if (this.id == null && id != null) this.id = id;
    }

}