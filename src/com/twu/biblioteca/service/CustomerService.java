package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.repository.BookRepository;

public class CustomerService {
    private BookRepository bookList;
    private Item borrowedBook;
    public CustomerService(BookRepository bookList) {
        this.bookList = bookList;
    }

    public Item getBorrowedBook() {
        return borrowedBook;
    }

    public String checkoutBook(String title) {
        Item item = bookList.findByTitle(title);
        if (item != null && !item.isBorrowed()) {
            item.setBorrowed(true);
            borrowedBook = item;
        }
        return getMessage(item);
    }

    private String getMessage(Item book) {
        String message = "";
        if (book != null && book.equals(borrowedBook)) {
            message = "Thank you! Enjoy the book";
        } else {
            message = "That book is not available.";
        }
        return message;
    }

    public String returnBook() {
        String message = "";
        int indexOfBook = bookList.getItems().indexOf(borrowedBook);
        message = getReturnMessage(indexOfBook);
        borrowBook(indexOfBook);
        return message;
    }

    private void borrowBook(int indexOfBook) {
        if (indexOfBook > -1) {
            bookList.getItems().get(indexOfBook).setBorrowed(false);
            borrowedBook = null;
        }
    }

    private String getReturnMessage(int indexOfBook) {
        String message = "";
        if (indexOfBook > -1) {
            message = "Thank you for returning the book.";
        } else {
            message = "That is not a valid book to return.";
        }
        return message;
    }


}
