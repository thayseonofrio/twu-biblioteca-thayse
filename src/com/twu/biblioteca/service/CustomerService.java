package com.twu.biblioteca.service;


import com.twu.biblioteca.model.Item;

import java.util.List;

public class CustomerService {

    private ItemFactory bookService;
    private ItemFactory movieService;
    public CustomerService() {
         bookService = ItemFactory.getInstance(ItemFactory.ItemType.BOOK);
         movieService = ItemFactory.getInstance(ItemFactory.ItemType.MOVIE);
    }

    public String checkoutBook(String title) {
        return bookService.checkoutItem(title);
    }

    public String returnBook() {
        return bookService.returnItem();
    }

    public Item getBorrowedBook() {
        return bookService.getBorrowedItem();
    }

    public void printBook() {
        bookService.printItemList();
    }

    public List<Item> getBooks() { return bookService.getItems(); }

    public List<Item> getAvailableBooks() { return bookService.getAvailableItems(); }

    public void addBook(Item item) {
        bookService.addItem(item);
    }

    public String checkoutMovie(String title) {
        return movieService.checkoutItem(title);
    }

    public String returnMovie() {
        return movieService.returnItem();
    }

    public Item getBorrowedMovie() {
        return movieService.getBorrowedItem();
    }

    public void printMovie() {
        movieService.printItemList();
    }

    public List<Item> getMovies() { return movieService.getItems(); }

    public List<Item> getAvailableMovies() { return movieService.getAvailableItems(); }

    public void addMovie(Item item) {
        movieService.addItem(item);
    }

}
