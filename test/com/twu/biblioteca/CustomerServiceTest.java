package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CustomerServiceTest {
    BookRepository bookList;
    CustomerService customerService;
    @Before
    public void setUp() {
        bookList = new BookRepository();
        customerService = new CustomerService(bookList);
    }

    @Test
    public void shouldCheckoutBook() {
        String bookToCheckout = "Harry Potter 2";
        customerService.checkoutBook(bookToCheckout);
        assertEquals(bookList.getBooks().size() - 1, bookList.getAvailableBooks().size());
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
        bookList.addBook(book);
        customerService.checkoutBook(book.getTitle());
        assertEquals(customerService.borrowedBook, book);
    }

    @Test
    public void shouldAddBookToList() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addBook(book);
        Book foundBook = bookList.findBookByTitle(book.getTitle());
        assertEquals(foundBook, book);
    }

    @Test
    public void shouldReturnBook() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addBook(book);
        customerService.checkoutBook(book.getTitle());
        int availableBooksSizeWithoutBook = bookList.getAvailableBooks().size();
        customerService.returnBook();
        assertNull(customerService.borrowedBook);
        assertEquals(availableBooksSizeWithoutBook + 1, bookList.getAvailableBooks().size());
    }

    @Test
    public void shouldShowSuccessfulReturnMessage() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addBook(book);
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
