package com.twu.biblioteca.model;

public class UserSession {
    public static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserSession.user = user;
    }

    public static boolean isLoggedIn() {
        boolean loggedIn = false;
        if (user != null)
            loggedIn = true;
        return loggedIn;
    }
}
