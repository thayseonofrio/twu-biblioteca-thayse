package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CustomerTest {
    BookList bookList;
    Customer customer;
    @Before
    public void setUp() {
        bookList = new BookList();
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
}
