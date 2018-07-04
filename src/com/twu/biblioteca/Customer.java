package com.twu.biblioteca;

public class Customer {
    BookList bookList;

    public Customer(BookList bookList) {
        this.bookList = bookList;
    }

    public String checkoutBook(String title) {
        Book book = bookList.findBookByTitle(title);
        Boolean removed = bookList.getBooks().remove(book);
        return getMessage(removed);
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
