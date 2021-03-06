package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldCreateNewBook() {
        Book book = new Book("Harry Potter", "J. K. Rowling", 1997);
        assertEquals("Harry Potter", book.getTitle());
        assertEquals("J. K. Rowling", book.getAuthor());
        assertEquals(1997, book.getYear());
    }

    @Test
    public void shouldPrintBookDetails() {
        Book book = new Book("Harry Potter", "J. K. Rowling", 1997);
        System.out.print(book.toString());
        assertEquals("Harry Potter\tJ. K. Rowling\t1997", outContent.toString());
    }

    @Test
    public void shouldCreateBookNotBorrowedByDefault() {
        Book book = new Book("Harry Potter", "J. K. Rowling", 1997);
        assertFalse(book.isBorrowed());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}
