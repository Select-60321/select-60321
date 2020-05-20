package com.example.demo59.controller;

import javax.validation.constraints.NotBlank;

public class LogInform {
    @NotBlank(message = "Username shouldn't be null")
    private String userName;
    @NotBlank(message = "Password should't be null")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
