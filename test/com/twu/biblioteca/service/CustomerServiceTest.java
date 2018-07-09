package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// TODO: Mock repositories
public class CustomerServiceTest {
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private CustomerService customerService;
    @Before
    public void setUp() {
        bookRepository = new BookRepository();
        movieRepository = new MovieRepository();
        customerService = new CustomerService(bookRepository, movieRepository);
    }

    @Test
    public void shouldCheckoutBook() {
        String bookToCheckout = "Harry Potter 2";
        customerService.checkoutBook(bookToCheckout);
        assertEquals(bookRepository.getItems().size() - 1, bookRepository.getAvailableItems().size());
    }

    @Test
    public void shouldCheckoutMovie() {
        Movie movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        movieRepository.addItem(movie);
        String movieToCheckout = "Incredibles 2";
        customerService.checkoutMovie(movieToCheckout);
        assertEquals(movieRepository.getItems().size() - 1, movieRepository.getAvailableItems().size());
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
        bookRepository.addItem(book);
        customerService.checkoutBook(book.getTitle());
        assertEquals(customerService.getBorrowedBook(), book);
    }

    @Test
    public void shouldKeepMovieWithCustomer() {
        Movie movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        movieRepository.addItem(movie);
        customerService.checkoutMovie(movie.getTitle());
        assertEquals(customerService.getBorrowedMovie(), movie);
    }


    @Test
    public void shouldReturnBook() {
        Item book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookRepository.addItem(book);
        customerService.checkoutBook(book.getTitle());
        int availableBooksSizeWithoutBook = bookRepository.getAvailableItems().size();
        customerService.returnBook();
        assertNull(customerService.getBorrowedBook());
        assertEquals(availableBooksSizeWithoutBook + 1, bookRepository.getAvailableItems().size());
    }

    @Test
    public void shouldReturnMovie() {
        Item movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        movieRepository.addItem(movie);
        customerService.checkoutMovie(movie.getTitle());
        int availableMoviesSizeWithoutMovie = movieRepository.getAvailableItems().size();
        customerService.returnMovie();
        assertNull(customerService.getBorrowedMovie());
        assertEquals(availableMoviesSizeWithoutMovie + 1, movieRepository.getAvailableItems().size());
    }

    @Test
    public void shouldShowSuccessfulBookReturnMessage() {
        Book book = new Book("The Old Man and the Sea", "Hemingway", 1952);
        bookRepository.addItem(book);
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
        movieRepository.addItem(movie);
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
