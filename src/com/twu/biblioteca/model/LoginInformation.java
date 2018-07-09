package com.twu.biblioteca.model;

public class LoginInformation {
    // TODO: prevent wrong format in library number
    private String libraryNumber;
    private String password;

    public LoginInformation(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
