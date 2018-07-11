package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerServiceTest {
    private CustomerService customerService;
    @Before
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void shouldCheckoutBook() {
        String bookToCheckout = "Harry Potter 2";
        customerService.checkoutBook(bookToCheckout);
        assertEquals(customerService.getBooks().size() - 1, customerService.getAvailableBooks().size());
    }

    @Test
    public void shouldCheckoutMovie() {
        Movie movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        customerService.addMovie(movie);
        String movieToCheckout = "Incredibles 2";
        customerService.checkoutMovie(movieToCheckout);
        assertEquals(customerService.getMovies().size() - 1, customerService.getAvailableMovies().size());
    }

    @Test
    public void shouldShowSuccessfulBookCheckoutMessage() {
        String bookToCheckout = "Harry Potter 2";
        String message = customerService.checkoutBook(bookToCheckout);
        assertEquals("Thank you! Enjoy the book", message);
    }

    @Test
    public void shouldShowUnsuccessfulBookCheckoutMessage() {
        String bookToCheckout = "Harry Pfihd 2";
        String message = customerService.checkoutBook(bookToCheckout);
        assertEquals("That book is not available.", message);
    }

    @Test
    public void shouldShowSucessfulMovieCheckoutMessage() {
        String movieToCheckout = "Black Panther";
        String message = customerService.checkoutMovie(movieToCheckout);
        assertEquals("Thank you! Enjoy the movie", message);
    }

    @Test
    public void shouldShowUnsucessfulMovieCheckoutMessage() {
        String movieToCheckout = "Black Pther";
        String message = customerService.checkoutMovie(movieToCheckout);
        assertEquals("That movie is not available.", message);
    }

    @Test
    public void shouldKeepBookWithCustomer() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        customerService.addBook(book);
        customerService.checkoutBook(book.getTitle());
        assertEquals(customerService.getBorrowedBook(), book);
    }

    @Test
    public void shouldKeepMovieWithCustomer() {
        Movie movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        customerService.addMovie(movie);
        customerService.checkoutMovie(movie.getTitle());
        assertEquals(customerService.getBorrowedMovie(), movie);
    }


    @Test
    public void shouldReturnBook() {
        Item book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        customerService.addBook(book);
        customerService.checkoutBook(book.getTitle());
        int availableBooksSizeWithoutBook = customerService.getAvailableBooks().size();
        customerService.returnBook();
        assertNull(customerService.getBorrowedBook());
        assertEquals(availableBooksSizeWithoutBook + 1, customerService.getAvailableBooks().size());
    }

    @Test
    public void shouldReturnMovie() {
        Item movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        customerService.addMovie(movie);
        customerService.checkoutMovie(movie.getTitle());
        int availableMoviesSizeWithoutMovie = customerService.getAvailableMovies().size();
        customerService.returnMovie();
        assertNull(customerService.getBorrowedMovie());
        assertEquals(availableMoviesSizeWithoutMovie + 1, customerService.getAvailableMovies().size());
    }

    @Test
    public void shouldShowSuccessfulBookReturnMessage() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        customerService.addBook(book);
        customerService.checkoutBook(book.getTitle());
        String message = customerService.returnBook();
        assertEquals("Thank you for returning the book.", message);
    }

    @Test
    public void  shouldShowUnsuccessfulBookReturnMessage() {
        String message = customerService.returnBook();
        assertEquals("That is not a valid book to return.", message);
    }

    @Test
    public void shouldShowSuccessfulMovieReturnMessage() {
        Item movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        customerService.addMovie(movie);
        customerService.checkoutMovie(movie.getTitle());
        String message = customerService.returnMovie();
        assertEquals("Thank you for returning the movie.", message);
    }

    @Test
    public void shouldShowUnsuccessfulMovieReturnMessage() {
        String message = customerService.returnMovie();
        assertEquals("That is not a valid movie to return.", message);
    }
}
