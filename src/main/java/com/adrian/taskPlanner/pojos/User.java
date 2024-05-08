package com.adrian.taskPlanner.pojos;

import com.adrian.taskPlanner.utilities.Encrypt;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    //TODO @Convert(converter = Encrypt.class)
    private String password;
    private LocalDate registerDate;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserAccess> userAccess;


    private User(){}

    public User(String username, String password, LocalDate registerDate){
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }

    public Integer getId(){
        return this.id;
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

    public List<UserAccess> getUserAccess() {
        return userAccess;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", userAccess=" + userAccess +
                '}';
    }
}
