package com.twu.biblioteca.model;

import org.junit.Test;
import static org.junit.Assert.*;
public class RatingTest {

    @Test
    public void shouldCreateValidRating() {
        Rating rating = new Rating(2);
        assertEquals(2, rating.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidValue() {
        new Rating(50);
    }
}
