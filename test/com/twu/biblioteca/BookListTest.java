package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class BookListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    // TODO: verificar nomemclatura dos testes
    @Test
    public void shouldGetBookList() {
        BookList bookList = new BookList();
        // TODO: verificar se pode ter dois asserts no mesmo teste
        assertEquals(bookList.getBooks().size(), 2);
        assertEquals(bookList.getBooks().get(0).getTitle(), "Harry Potter");
        assertEquals(bookList.getBooks().get(1).getYear(), 1999);
    }

    @Test
    public void shouldPrintBookList() {
        BookList bookList = new BookList();
        System.out.print(bookList);
        assertEquals("Harry Potter\tJ. K. Rowling\t1997\nHarry Potter 2\tJ. K. Rowling\t1999\n", outContent.toString());
    }

    @Test
    public void shouldFindBookByTitle() {
        BookList bookList = new BookList();
        String title = "Harry Potter";
        Book book = bookList.findBookByTitle(title);
        assertEquals(title, book.getTitle());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
