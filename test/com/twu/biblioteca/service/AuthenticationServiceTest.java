package com.twu.biblioteca.service;
import org.junit.Test;
import static org.junit.Assert.*;
public class AuthenticationServiceTest {
    @Test
    public void shouldCreateAuthenticationServiceWithInputData() {
        AuthenticationService authenticationService =  new AuthenticationService("123-4567", "pass123");
        assertNotNull(authenticationService);
    }

    @Test
    public void shouldVerifyCredentials() {
        AuthenticationService authenticationService =  new AuthenticationService("123-4567", "pass123");
        boolean valid = authenticationService.verifyCredentials();
        assertTrue(valid);
    }

    @Test
    public void shouldIdentifyInvalidLibraryID() {
        AuthenticationService authenticationService =  new AuthenticationService("123-67", "pass123");
        boolean valid = authenticationService.verifyCredentials();
        assertFalse(valid);
    }

    @Test
    public void shouldIdentifyInvalidPassword() {
        AuthenticationService authenticationService =  new AuthenticationService("123-4567", "pass23");
        boolean valid = authenticationService.verifyCredentials();
        assertFalse(valid);
    }
}
