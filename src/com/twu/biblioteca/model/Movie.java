package com.twu.biblioteca.model;

public class Movie extends Item {
    private String director;
    private Rating rating;

    public Movie(String title, int year, String director) {
        super(title, year);
        this.director = director;
    }

    public Movie(String title, int year, String director, int rating) {
        super(title, year);
        this.director = director;
        this.rating = new Rating(rating);
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        // TODO: find better way to do this
        if (rating == null) {
            return 0;
        }
        return rating.getValue();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(getTitle());
        string.append("\t");
        string.append(getDirector());
        string.append("\t");
        string.append(getYear());
        string.append("\t");
        string.append(getRating());
        return string.toString();
    }
}
