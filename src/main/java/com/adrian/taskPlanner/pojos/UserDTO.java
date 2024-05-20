package com.adrian.taskPlanner.pojos;


import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UserDTO() {
        this.username = "";
        this.password = "";
    }
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
