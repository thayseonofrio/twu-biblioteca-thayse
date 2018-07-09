package com.twu.biblioteca.model;

public class Book extends Item {
    private String author;

    public Book(String title, String author, int year) {
        super(title, year);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(getTitle());
        string.append("\t");
        string.append(getAuthor());
        string.append("\t");
        string.append(getYear());
        return string.toString();
    }
}
