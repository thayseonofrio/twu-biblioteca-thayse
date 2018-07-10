package com.twu.biblioteca.model;

public class User {
    private LoginInformation loginInformation;
    private String name;
    private String email;
    private String phoneNumber;
    public User(LoginInformation loginInformation, String name, String email, String phoneNumber) {
        this.loginInformation = loginInformation;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public LoginInformation getLoginInformation() {
        return loginInformation;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("User Information:");
        string.append("\n");
        string.append(getName());
        string.append("\t");
        string.append(getEmail());
        string.append("\t");
        string.append(getPhoneNumber());
        return string.toString();
    }
}
