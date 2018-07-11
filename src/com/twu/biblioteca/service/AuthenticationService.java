package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserSession;
import com.twu.biblioteca.repository.UserRepository;

import java.util.Optional;
import java.util.stream.Stream;

public class AuthenticationService {
    private String inputLogin;
    private String inputPassword;
    UserRepository userRepository = new UserRepository();
    public AuthenticationService(String inputLogin, String inputPassword) {
        this.inputLogin = inputLogin;
        this.inputPassword = inputPassword;
    }

    public boolean verifyCredentials() {
        boolean validation = false;
        Optional<User> foundUser = userRepository.getUsers()
                .stream()
                .filter(user -> user.getLoginInformation()
                        .getLibraryNumber().equals(inputLogin))
                .findFirst();
        if (!foundUser.isPresent()) {
            return validation;
        }
        validation = foundUser.get().getLoginInformation().getPassword().equals(inputPassword);
        if (validation) {
            UserSession.setUser(foundUser.get());
        }
        return validation;
    }
}
