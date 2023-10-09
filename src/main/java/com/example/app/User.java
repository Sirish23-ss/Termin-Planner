package com.example.app;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id

    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id ;
    private String username;
    private String passwordSalt;
    private String passwordHash;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.passwordSalt = RandomStringUtils.random(32);
        this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean checkPassword(String password){
        return  DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
    }


}
