package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    BibliotecaApp app;
    @Before
    public void newInstance() {
        app = new BibliotecaApp();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void shouldGetWelcomeMessage() {
        String message = app.getWelcomeMessage();
        assertEquals("Welcome!", message);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
