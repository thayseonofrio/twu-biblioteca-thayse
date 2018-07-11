package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.repository.BookRepository;

import java.util.List;

import static com.twu.biblioteca.Constants.*;

public class BookService extends ItemFactory {
    private BookRepository bookRepository = new BookRepository();
    private Item borrowedBook;

    public Item getBorrowedItem() {
        return borrowedBook;
    }


    public String checkoutItem(String title) {
        Book item = (Book) bookRepository.findByTitle(title);
        borrowItem(item);
        return getCheckoutMessage(item);
    }


    private void borrowItem(Item item) {
        if (item != null && !item.isBorrowed()) {
            item.setBorrowed(true);
            borrowedBook = item;
        }
    }

    private String getCheckoutMessage(Book book) {
        String message = "";
        if (book != null && book.equals(borrowedBook)) {
            message = MESSAGE_BOOK_CHECKOUT_SUCCESS;
        } else {
            message = MESSAGE_BOOK_CHECKOUT_FAILURE;
        }
        return message;
    }


    public String returnItem() {
        String message = "";
        int indexOfBook = bookRepository.getItems().indexOf(borrowedBook);
        message = getReturnMessage(indexOfBook);
        clearBook(indexOfBook);
        return message;
    }



    private void clearBook(int indexOfBook) {
        if (indexOfBook > -1) {
            bookRepository.getItems().get(indexOfBook).setBorrowed(false);
            borrowedBook = null;
        }
    }


    private String getReturnMessage(int indexOfBook) {
        String message = "";
        if (indexOfBook > -1) {
            message = MESSAGE_BOOK_RETURN_SUCCESS;
        } else {
            message = MESSAGE_BOOK_RETURN_FAILURE;
        }
        return message;
    }

    public void printItemList() {
        System.out.println(bookRepository);
    }

    public List<Item> getItems() {
        return bookRepository.getItems();
    }

    public List<Item> getAvailableItems() {
        return bookRepository.getAvailableItems();
    }

    public void addItem(Item item) {
        bookRepository.addItem(item);
    }

}
