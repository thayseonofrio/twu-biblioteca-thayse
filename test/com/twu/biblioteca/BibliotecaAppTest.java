package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Test
    public void shouldGetWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp();
        String message = app.getWelcomeMessage();
        assertEquals(message, "Welcome!");
    }
}
