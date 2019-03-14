package com.example.jpaexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;
    @Column(columnDefinition = "DATETIME  NOT NULL "+
            "DEFAULT CURRENT_TIMESTAMP ON UPDATE "+
            "CURRENT_TIMESTAMP",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable=false,
            updatable=false)
    private LocalDateTime insertTime;
    public User(String name){
        this.name=name;
    }
}
