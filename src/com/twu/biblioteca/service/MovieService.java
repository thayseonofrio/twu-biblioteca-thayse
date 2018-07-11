package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.List;


public class MovieService extends ItemFactory {
    private Item borrowedMovie;
    private MovieRepository movieRepository = new MovieRepository();

    public Item getBorrowedItem() {
        return borrowedMovie;
    }

    public String checkoutItem(String title) {
        Movie item = (Movie) movieRepository.findByTitle(title);
        borrowItem(item);
        return getCheckoutMessage(item);
    }

    private void borrowItem(Item item) {
        if (item != null && !item.isBorrowed()) {
            item.setBorrowed(true);
            borrowedMovie = item;
        }
    }

    private String getCheckoutMessage(Movie movie) {
        String message = "";
        if (movie != null && movie.equals(borrowedMovie)) {
            message = Constants.MESSAGE_MOVIE_CHECKOUT_SUCCESS;
        } else {
            message = Constants.MESSAGE_MOVIE_CHECKOUT_FAILURE;
        }
        return message;
    }

    public String returnItem() {
        String message = "";
        int indexOfMovie = movieRepository.getItems().indexOf(borrowedMovie);
        message = getReturnMessage(indexOfMovie);
        clearMovie(indexOfMovie);
        return message;
    }

    private void clearMovie(int indexOfMovie) {
        if (indexOfMovie > -1) {
            movieRepository.getItems().get(indexOfMovie).setBorrowed(false);
            borrowedMovie = null;
        }
    }

    private String getReturnMessage(int indexOfBook) {
        String message = "";
        if (indexOfBook > -1) {
            message = Constants.MESSAGE_MOVIE_RETURN_SUCCESS;
        } else {
            message = Constants.MESSAGE_MOVIE_RETURN_FAILURE;
        }
        return message;
    }

    public void printItemList() {
        System.out.println(movieRepository);
    }

    public List<Item> getItems() {
        return movieRepository.getItems();
    }

    public List<Item> getAvailableItems() {
        return movieRepository.getAvailableItems();
    }

    public void addItem(Item item) {
        movieRepository.addItem(item);
    }


    private interface Constants {
        String MESSAGE_MOVIE_CHECKOUT_SUCCESS = "Thank you! Enjoy the movie";
        String MESSAGE_MOVIE_CHECKOUT_FAILURE = "That movie is not available.";
        String MESSAGE_MOVIE_RETURN_SUCCESS = "Thank you for returning the movie.";
        String MESSAGE_MOVIE_RETURN_FAILURE = "That is not a valid movie to return.";
    }


}
