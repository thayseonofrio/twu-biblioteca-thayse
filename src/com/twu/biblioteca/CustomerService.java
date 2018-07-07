package com.twu.biblioteca;

public class CustomerService {
    BookRepository bookList;
    Book borrowedBook;
    public CustomerService(BookRepository bookList) {
        this.bookList = bookList;
    }

    public String checkoutBook(String title) {
        Book book = bookList.findBookByTitle(title);
        if (book != null) {
            book.setBorrowed(true);
            borrowedBook = book;
        }
        return getMessage(book);
    }

    private String getMessage(Book book) {
        String message = "";
        if (book != null && book.isBorrowed()) {
            message = "Thank you! Enjoy the book";
        } else {
            message = "That book is not available.";
        }
        return message;
    }

    public void returnBook() {
        int indexOfBook = bookList.getBooks().indexOf(borrowedBook);
        bookList.getBooks().get(indexOfBook).setBorrowed(false);
        borrowedBook = null;
    }


}
