package com.twu.biblioteca.model;

public class User {
    private LoginInformation loginInformation;

    public User(LoginInformation loginInformation) {
        this.loginInformation = loginInformation;
    }

    public LoginInformation getLoginInformation() {
        return loginInformation;
    }
}
