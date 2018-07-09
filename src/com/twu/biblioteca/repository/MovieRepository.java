package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements IItemRepository {
    private List<Item> movies = new ArrayList();

    public MovieRepository() {
        fillRepository();
    }

    public void addItem(Item item) {
        movies.add(item);
    }

    public List<Item> getItems() {
        return movies;
    }

    public void fillRepository() {
        movies.add(new Movie("Jurassic World", 2018, "J. A. Bayona", 8));
        movies.add(new Movie("Black Panther", 2018, "Ryan Coogler", 10));
    }
}
