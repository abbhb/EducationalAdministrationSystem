package com.ssmstudy.ssm.pojo.login;

import com.ssmstudy.ssm.pojo.User;

public class LoginResult {
    private String token;

    private User user;

    @Override
    public String toString() {
        return "LoginResult{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResult() {
    }

    public LoginResult(String token) {
        this.token = token;
    }
}
