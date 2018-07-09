package com.twu.biblioteca.service;

import static com.twu.biblioteca.Constants.*;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;

// TODO: Como deixar menos repetitivo?
public class CustomerService {
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private Item borrowedBook;
    private Item borrowedMovie;

    public CustomerService(BookRepository bookList, MovieRepository movieRepository) {
        this.bookRepository = bookList;
        this.movieRepository = movieRepository;
    }

    public Item getBorrowedBook() {
        return borrowedBook;
    }

    public Item getBorrowedMovie() {
        return borrowedMovie;
    }

    public String checkoutBook(String title) {
        Book item = (Book) bookRepository.findByTitle(title);
        borrowItem(item);
        return getBookCheckoutMessage(item);
    }

    public String checkoutMovie(String title) {
        Movie item = (Movie) movieRepository.findByTitle(title);
        borrowItem(item);
        return getMovieCheckoutMessage(item);
    }

    private void borrowItem(Item item) {
        if (item != null && !item.isBorrowed()) {
            item.setBorrowed(true);
            if (item instanceof Movie) {
                borrowedMovie = item;
            } else {
                borrowedBook = item;
            }
        }
    }

    private String getBookCheckoutMessage(Book book) {
        String message = "";
        if (book != null && book.equals(borrowedBook)) {
            message = MESSAGE_BOOK_CHECKOUT_SUCCESS;
        } else {
            message = MESSAGE_BOOK_CHECKOUT_FAILURE;
        }
        return message;
    }

    private String getMovieCheckoutMessage(Movie movie) {
        String message = "";
        if (movie != null && movie.equals(borrowedMovie)) {
            message = MESSAGE_MOVIE_CHECKOUT_SUCCESS;
        } else {
            message = MESSAGE_MOVIE_CHECKOUT_FAILURE;
        }
        return message;
    }

    public String returnBook() {
        String message = "";
        int indexOfBook = bookRepository.getItems().indexOf(borrowedBook);
        message = getBookReturnMessage(indexOfBook);
        clearBook(indexOfBook);
        return message;
    }

    public String returnMovie() {
        String message = "";
        int indexOfMovie = movieRepository.getItems().indexOf(borrowedMovie);
        message = getMovieReturnMessage(indexOfMovie);
        clearMovie(indexOfMovie);
        return message;
    }

    private void clearBook(int indexOfBook) {
        if (indexOfBook > -1) {
            bookRepository.getItems().get(indexOfBook).setBorrowed(false);
            borrowedBook = null;
        }
    }

    private void clearMovie(int indexOfMovie) {
        if (indexOfMovie > -1) {
            movieRepository.getItems().get(indexOfMovie).setBorrowed(false);
            borrowedMovie = null;
        }
    }

    private String getBookReturnMessage(int indexOfBook) {
        String message = "";
        if (indexOfBook > -1) {
            message = MESSAGE_BOOK_RETURN_SUCCESS;
        } else {
            message = MESSAGE_BOOK_RETURN_FAILURE;
        }
        return message;
    }

    private String getMovieReturnMessage(int indexOfBook) {
        String message = "";
        if (indexOfBook > -1) {
            message = MESSAGE_MOVIE_RETURN_SUCCESS;
        } else {
            message = MESSAGE_MOVIE_RETURN_FAILURE;
        }
        return message;
    }


}
