package com.twu.biblioteca.model;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginInformationTest {
    @Test
    public void shouldCreateLoginInformation() {
        LoginInformation info = null;
        try {
            info = new LoginInformation("123-4567", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("123-4567", info.getLibraryNumber());
        Assert.assertEquals("password", info.getPassword());
    }

    @Test
    public void shouldValidateLibraryNumber() {
        try {
            new LoginInformation("123", "password");
        } catch (Exception e) {
            assertEquals("Library number should be in format xxx-xxxx", e.getMessage());
        }
    }
}
