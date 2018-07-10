package com.twu.biblioteca.model;

import org.junit.Test;
import static org.junit.Assert.*;
public class UserTest {

    @Test
    public void shouldCreateUserWithLoginInformation() throws Exception {
        LoginInformation info = new LoginInformation("123-4567", "password");
        User user = new User(info,"name", "email", "number");
        assertEquals(info, user.getLoginInformation());
    }

    @Test
    public void shouldGetUserInformation() throws Exception {
        LoginInformation info = new LoginInformation("123-4567", "password");
        User user = new User(info,"name", "email", "number");
        assertEquals("name", user.getName());
        assertEquals("email", user.getEmail());
        assertEquals("number", user.getPhoneNumber());
    }
}
