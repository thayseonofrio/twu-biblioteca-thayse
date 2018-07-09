package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class MovieRepositoryTest {
    MovieRepository movieRepository;
    @Before
    public void createRepository() {
        movieRepository = new MovieRepository();
    }

    @Test
    public void shouldGetMovieList() {
        assertFalse(movieRepository.getItems().isEmpty());
    }

    @Test
    public void shouldGetAvailableMovies() {
        Movie movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        movie.setBorrowed(true);
        movieRepository.addItem(movie);
        int currentListSize = movieRepository.getItems().size();
        List<Item> availableMovies = movieRepository.getAvailableItems();
        assertEquals(currentListSize - 1, availableMovies.size());
    }

    @Test
    public void shouldFindMovieByTitle() {
        Movie movie = new Movie("Incredibles 2", 2018, "Brad Bird");
        movieRepository.addItem(movie);
        String title = "Incredibles 2";
        Item foundMovie = movieRepository.findByTitle(title);
        assertEquals(title, foundMovie.getTitle());
    }
}
