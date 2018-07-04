package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books = new ArrayList<Book>();

    public BookList() {
        fillList();
    }

    private void fillList() {
        books.add(new Book("Harry Potter", "J. K. Rowling", 1997));
        books.add(new Book("Harry Potter 2", "J. K. Rowling", 1999));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        Book foundBook = null;
        for (Book book : getBooks()) {
            if (title.equals(book.getTitle())) {
                foundBook = book;
            }
        }
        return foundBook;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Book book : books) {
            string.append(book.toString());
            string.append("\n");
        }
        return string.toString();
    }
}
