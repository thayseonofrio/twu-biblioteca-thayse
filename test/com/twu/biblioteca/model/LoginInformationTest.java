package com.twu.biblioteca.model;

import org.junit.Assert;
import org.junit.Test;

public class LoginInformationTest {
    @Test
    public void shouldCreateLoginInformation() {
        LoginInformation info = new LoginInformation("123-4567", "password");
        Assert.assertEquals("123-4567", info.getLibraryNumber());
        Assert.assertEquals("password", info.getPassword());
    }
}
