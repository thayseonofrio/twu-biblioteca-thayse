package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.LoginInformation;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList();
    public UserRepository() {
        users.add(new User(new LoginInformation("123-4567", "pass123"), "Mary", "mary@gmail.com", "+555192929292"));
        users.add(new User(new LoginInformation("222-2222", "9876543"), "John", "john@gmail.com", "+5551920239282"));
    }

    public List<User> getUsers() {
        return users;
    }
}
