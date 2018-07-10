package com.twu.biblioteca.model;

import org.junit.Test;
import static org.junit.Assert.*;
public class UserSessionTest {

    @Test
    public void shouldSetUserSession() {
        User user = null;
        try {
            user = new User(new LoginInformation("111-1111", "222"), "name", "email", "number");
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserSession.setUser(user);
        assertNotNull(UserSession.user);
    }

    @Test
    public void shouldNotSetUserSessionForEmptyUser() {
        User user = null;
        UserSession.setUser(user);
        assertNull(UserSession.user);
    }

    @Test
    public void shouldCheckIfUserIsLoggedIn() {
        User user = null;
        try {
            user = new User(new LoginInformation("111-1111", "222"), "name", "email", "number");
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserSession.setUser(user);
        assertTrue(UserSession.isLoggedIn());
    }
}
