package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Item;

import java.util.ArrayList;
import java.util.List;

public interface IItemRepository {
    void fillRepository();
    List<Item> getItems();
    void addItem(Item item);

    default Item findByTitle(String title) {
        Item foundItem = null;
        for (Item book : getItems()) {
            if (title.equals(book.getTitle())) {
                foundItem = book;
            }
        }
        return foundItem;
    }


    default List<Item> getAvailableItems() {
        List<Item> availableItems = new ArrayList();
        for (Item item : getItems()) {
            if(!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }
}
