package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BookRepositoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    BookRepository bookRepository;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void createBookRepository() {
        bookRepository = new BookRepository();
    }

    @Test
    public void shouldGetBookList() {
        assertFalse(bookRepository.getBooks().isEmpty());
    }

    @Test
    public void shouldGetAvailableBooks() {
        Book book = new Book("title", "author", 2000);
        book.setBorrowed(true);
        bookRepository.addBook(book);
        int currentListSize = bookRepository.getBooks().size();
        ArrayList<Book> availableBooks = bookRepository.getAvailableBooks();
        assertEquals(currentListSize - 1, availableBooks.size());
    }

    @Test
    public void shouldPrintBookList() {
        System.out.print(bookRepository);
        assertEquals("Harry Potter\tJ. K. Rowling\t1997\nHarry Potter 2\tJ. K. Rowling\t1999\n", outContent.toString());
    }

    @Test
    public void shouldFindBookByTitle() {
        String title = "Harry Potter";
        Book book = bookRepository.findBookByTitle(title);
        assertEquals(title, book.getTitle());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
