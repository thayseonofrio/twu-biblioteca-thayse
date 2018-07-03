package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldCreateNewBook() {
        Book book = new Book("Harry Potter", "J. K. Rowling", 1997);
        assertEquals(book.getTitle(), "Harry Potter");
        assertEquals(book.getAuthor(), "J. K. Rowling");
        assertEquals(book.getYear(), 1997);
    }

    @Test
    public void shouldPrintBookDetails() {
        Book book = new Book("Harry Potter", "J. K. Rowling", 1997);
        System.out.print(book.toString());
        assertEquals("Harry Potter\tJ. K. Rowling\t1997", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}
