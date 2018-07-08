package com.twu.biblioteca;

public class CustomerService {
    BookRepository bookList;
    Book borrowedBook;
    public CustomerService(BookRepository bookList) {
        this.bookList = bookList;
    }

    public String checkoutBook(String title) {
        Book book = bookList.findBookByTitle(title);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            borrowedBook = book;
        }
        return getMessage(book);
    }

    private String getMessage(Book book) {
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
        int indexOfBook = bookList.getBooks().indexOf(borrowedBook);
        message = getReturnMessage(indexOfBook);
        borrowBook(indexOfBook);
        return message;
    }

    private void borrowBook(int indexOfBook) {
        if (indexOfBook > -1) {
            bookList.getBooks().get(indexOfBook).setBorrowed(false);
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
