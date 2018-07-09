package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.*;
public class MovieTest {

    @Test
    public void shouldCreateMovie() {
        Movie movie = new Movie("title", 1990, "director", 1);
        assertEquals("title", movie.getTitle());
        assertEquals(1990, movie.getYear());
        assertEquals("director", movie.getDirector());
        assertEquals(1, movie.getRating());
    }

    @Test
    public void shouldCreateUnratedMovie() {
        Movie movie = new Movie("title", 1990, "director");
        assertEquals("title", movie.getTitle());
        assertEquals(1990, movie.getYear());
        assertEquals("director", movie.getDirector());
        assertEquals(0, movie.getRating());
    }
}
