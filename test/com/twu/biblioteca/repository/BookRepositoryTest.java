package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.List;

public class BookRepositoryTest {

    BookRepository bookRepository;

    @Before
    public void createBookRepository() {
        bookRepository = new BookRepository();
    }

    @Test
    public void shouldGetBookList() {
        assertFalse(bookRepository.getItems().isEmpty());
    }

    @Test
    public void shouldGetAvailableBooks() {
        Book book = new Book("title", "author", 2000);
        book.setBorrowed(true);
        bookRepository.addItem(book);
        int currentListSize = bookRepository.getItems().size();
        List<Item> availableBooks = bookRepository.getAvailableItems();
        assertEquals(currentListSize - 1, availableBooks.size());
    }


    @Test
    public void shouldFindBookByTitle() {
        Book book = new Book("title", "author", 2000);
        bookRepository.addItem(book);
        String title = "title";
        Item foundBook = bookRepository.findByTitle(title);
        assertEquals(title, foundBook.getTitle());
    }


    @Test
    public void shouldAddBookToList() {
        Item item = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookRepository.addItem(item);
        Item foundBook = bookRepository.findByTitle(item.getTitle());
        assertEquals(foundBook, item);
    }

}
