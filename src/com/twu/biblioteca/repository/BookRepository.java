package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IItemRepository {
    private List<Item> books = new ArrayList();

    public BookRepository() {
        fillRepository();
    }

    public void fillRepository() {
        books.add(new Book("Harry Potter", "J. K. Rowling", 1997));
        books.add(new Book("Harry Potter 2", "J. K. Rowling", 1999));
    }

    public List<Item> getItems() {
        return books;
    }

    public void addItem(Item item) {
        books.add(item);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Item item : getAvailableItems()) {
            string.append(item.toString());
            string.append("\n");
        }
        return string.toString();
    }
}
