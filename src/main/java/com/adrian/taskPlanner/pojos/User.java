package com.adrian.taskPlanner.pojos;

import com.adrian.taskPlanner.utilities.Encrypt;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    @Convert(converter = Encrypt.class)
    private String password;
    private LocalDate registerDate;

    private User(){}

    private User(String username, String password, LocalDate registerDate){
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public LocalDate getRegisterDate(){
        return this.registerDate;
    }

}
