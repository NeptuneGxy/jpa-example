package com.example.jpaexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    @ManyToOne
    private User user;
    @Column(columnDefinition = "DATETIME NOT NULL "+
            "DEFAULT CURRENT_TIMESTAMP ON UPDATE "+
            "CURRENT_TIMESTAMP",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;
    @Column(columnDefinition = "TIMESTAMP NOT NULL "+
            "DEFAULT CURRENT_TIMESTAMP",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;
    public Address(String detail){
        this.detail=detail;
    }
}
