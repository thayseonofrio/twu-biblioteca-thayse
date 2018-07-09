package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.LoginInformation;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList();
    public UserRepository() {
        users.add(new User(new LoginInformation("123-4567", "pass123")));
        users.add(new User(new LoginInformation("222-2222", "9876543")));
    }

    public List<User> getUsers() {
        return users;
    }
}
