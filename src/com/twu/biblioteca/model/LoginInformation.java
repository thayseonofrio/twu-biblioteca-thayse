package com.twu.biblioteca.model;

import java.text.ParseException;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.regex.Pattern;

public class LoginInformation {
    final static Pattern idFormat = Pattern.compile("\\d{3}-\\d{4}");
    private String libraryNumber;
    private String password;

    public LoginInformation(String libraryNumber, String password) throws Exception {
        setLibraryNumber(libraryNumber);
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    private void setLibraryNumber(String libraryNumber) throws Exception {
        if (validateLibraryNumber(libraryNumber)) {
            this.libraryNumber = libraryNumber;
        }
        else {
            throw new Exception("Library number should be in format xxx-xxxx");
        }
    }

    private boolean validateLibraryNumber(String libraryNumber) {
        return idFormat.matcher(libraryNumber).matches();
    }
}
