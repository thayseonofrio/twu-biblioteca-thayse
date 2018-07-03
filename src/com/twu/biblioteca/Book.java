package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
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
