package com.twu.biblioteca.model;

import org.junit.Test;
import static org.junit.Assert.*;
public class UserSessionTest {

    @Test
    public void shouldSetUserSession() {
        User user = new User(new LoginInformation("111", "222"));
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
        User user = new User(new LoginInformation("111", "222"));
        UserSession.setUser(user);
        assertTrue(UserSession.isLoggedIn());
    }
}
