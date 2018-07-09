package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CustomerServiceTest {
    private BookRepository bookList;
    private CustomerService customerService;
    @Before
    public void setUp() {
        bookList = new BookRepository();
        customerService = new CustomerService(bookList);
    }

    @Test
    public void shouldCheckoutBook() {
        String bookToCheckout = "Harry Potter 2";
        customerService.checkoutBook(bookToCheckout);
        assertEquals(bookList.getItems().size() - 1, bookList.getAvailableItems().size());
    }

    @Test
    public void shouldShowSuccessfulCheckoutMessage() {
        String bookToCheckout = "Harry Potter 2";
        String message = customerService.checkoutBook(bookToCheckout);
        assertEquals("Thank you! Enjoy the book", message);
    }

    @Test
    public void shouldShowUnsuccessfulCheckoutMessage() {
        String bookToCheckout = "Harry Pfihd 2";
        String message = customerService.checkoutBook(bookToCheckout);
        assertEquals("That book is not available.", message);
    }

    @Test
    public void shouldKeepBookWithCustomer() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addItem(book);
        customerService.checkoutBook(book.getTitle());
        assertEquals(customerService.getBorrowedBook(), book);
    }

    @Test
    public void shouldAddBookToList() {
        Item item = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addItem(item);
        Item foundBook = bookList.findByTitle(item.getTitle());
        assertEquals(foundBook, item);
    }

    @Test
    public void shouldReturnBook() {
        Item book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addItem(book);
        customerService.checkoutBook(book.getTitle());
        int availableBooksSizeWithoutBook = bookList.getAvailableItems().size();
        customerService.returnBook();
        assertNull(customerService.getBorrowedBook());
        assertEquals(availableBooksSizeWithoutBook + 1, bookList.getAvailableItems().size());
    }

    @Test
    public void shouldShowSuccessfulReturnMessage() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addItem(book);
        customerService.checkoutBook(book.getTitle());
        String message = customerService.returnBook();
        assertEquals("Thank you for returning the book.", message);
    }

    @Test
    public void  shouldShowUnsuccessfulReturnMessage() {
        String message = customerService.returnBook();
        assertEquals("That is not a valid book to return.", message);
    }
}
