package com.twu.biblioteca;

public class Customer {
    BookRepository bookList;
    Book borrowedBook;
    public Customer(BookRepository bookList) {
        this.bookList = bookList;
    }

    public String checkoutBook(String title) {
        Book book = bookList.findBookByTitle(title);
        Boolean removed = bookList.getBooks().remove(book);
        borrowBook(book, removed);
        return getMessage(removed);
    }

    private void borrowBook(Book book, Boolean removed) {
        if (removed) {
            borrowedBook = book;
        }
    }

    private String getMessage(Boolean removed) {
        String message = "";
        if (removed) {
            message = "Thank you! Enjoy the book";
        } else {
            message = "That book is not available.";
        }
        return message;
    }


}