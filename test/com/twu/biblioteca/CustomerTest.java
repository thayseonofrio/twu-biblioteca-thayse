package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CustomerTest {
    BookRepository bookList;
    Customer customer;
    @Before
    public void setUp() {
        bookList = new BookRepository();
        customer = new Customer(bookList);
    }

    @Test
    public void shouldCheckoutBook() {
        String bookToCheckout = "Harry Potter 2";
        customer.checkoutBook(bookToCheckout);
        assertEquals(bookList.getBooks().size(), 1);
    }

    @Test
    public void shouldShowSuccessfulCheckoutMessage() {
        String bookToCheckout = "Harry Potter 2";
        String message = customer.checkoutBook(bookToCheckout);
        assertEquals("Thank you! Enjoy the book", message);
    }

    @Test
    public void shouldShowUnsuccessfulCheckoutMessage() {
        String bookToCheckout = "Harry Pfihd 2";
        String message = customer.checkoutBook(bookToCheckout);
        assertEquals("That book is not available.", message);
    }

    @Test
    public void shouldKeepBookWithCustomer() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookList.addBook(book);
        customer.checkoutBook(book.getTitle());
        assertEquals(customer.borrowedBook, book);
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
        customer.checkoutBook(book.getTitle());
        int listSizeWithoutBook = bookList.getBooks().size();
        customer.returnBook();
        assertNull(customer.borrowedBook);
        assertEquals(listSizeWithoutBook + 1, bookList.getBooks().size());
    }
}
