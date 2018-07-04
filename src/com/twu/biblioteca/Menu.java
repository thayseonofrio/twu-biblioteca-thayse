package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<Integer, String> menu = new HashMap<Integer, String>();

    public Menu() {
        fillOptions();
        showMenuOptions();
        int userInput = getUserInput();
        chooseOption(userInput);
    }

    public void fillOptions() {
        menu.put(1, "List Books");
    }


    public HashMap<Integer, String> getMenu() {
        return menu;
    }

    public void showMenuOptions() {
        for (Map.Entry<Integer, String> entry : getMenu().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void chooseOption(int userInput) {
        switch(userInput) {
            case 1:
                BookList bookList = new BookList();
                System.out.println(bookList);
                break;
        }
    }

    private int getUserInput() {
        System.out.println("Insert a number to access a menu item");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        try {
            String s = br.readLine();
            if (s.length() > 0) {
                result = Integer.parseInt(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
