package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class BookRepositoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldGetBookList() {
        BookRepository bookList = new BookRepository();
        assertFalse(bookList.getBooks().isEmpty());
    }

    @Test
    public void shouldPrintBookList() {
        BookRepository bookList = new BookRepository();
        System.out.print(bookList);
        assertEquals("Harry Potter\tJ. K. Rowling\t1997\nHarry Potter 2\tJ. K. Rowling\t1999\n", outContent.toString());
    }

    @Test
    public void shouldFindBookByTitle() {
        BookRepository bookList = new BookRepository();
        String title = "Harry Potter";
        Book book = bookList.findBookByTitle(title);
        assertEquals(title, book.getTitle());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
