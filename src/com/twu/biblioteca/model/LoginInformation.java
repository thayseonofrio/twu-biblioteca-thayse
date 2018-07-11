package com.twu.biblioteca.model;
import java.util.regex.Pattern;

public class LoginInformation {
    final static Pattern idFormat = Pattern.compile("\\d{3}-\\d{4}");
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

    public boolean isValidLibraryNumber(String libraryNumber) {
        boolean result = false;
        if (validateLibraryNumber(libraryNumber)) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    private boolean validateLibraryNumber(String libraryNumber) {
        return idFormat.matcher(libraryNumber).matches();
    }
}
