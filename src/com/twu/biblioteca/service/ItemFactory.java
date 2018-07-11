package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Item;

import java.util.List;

public abstract class ItemFactory {
    private static ItemFactory instance = null;

    public enum ItemType {
        BOOK,
        MOVIE
    }

    public static ItemFactory getInstance(ItemType type) {
        if (type.equals(ItemType.BOOK)) {
            instance = new BookService();
        } else if (type.equals(ItemType.MOVIE)) {
            instance = new MovieService();
        }
        return instance;
    }

    public abstract String checkoutItem(String title);

    public abstract String returnItem();

    public abstract Item getBorrowedItem();

    public abstract void printItemList();

    public abstract List<Item> getItems();

    public abstract List<Item> getAvailableItems();

    public abstract void addItem(Item item);
}
