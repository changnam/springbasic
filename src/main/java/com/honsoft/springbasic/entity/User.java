package com.honsoft.springbasic.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;
    
    @Transient
    private String email;

}