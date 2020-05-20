package com.example.demo59.controller;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class RegisterForm {
    @NotBlank(message = "Username shouldn't be null")
    private String userName;
    @Length(min = 6, max = 16, message = "Password need at least 6 and at most 16")
    private String password;
    @NotBlank(message = "Confirm password shouldn't be null")
    private String confirmPassword;
    @Length(min = 11, max = 11, message = "Phone number must be 11 bits")
    private String phoneNumber;
    @Length(min = 18, max = 18, message = "Input the right id card number")
    private String idCardNum;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }
}
