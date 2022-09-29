package com.luochen.financial.user.entity;

import lombok.Data;

@Data
public class LoginInfo {
    private String username;
    private String password;
    private String token;

    public LoginInfo(String token) {
        this.token = token;
    }
}
