package com.example.bankingSystem.Dtos;

/**
 * Created by mandeep.singh on 1:16 AM 23/03/21 Tuesday
 */
public class SignInRequest {
    String userName;
    String password;

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
