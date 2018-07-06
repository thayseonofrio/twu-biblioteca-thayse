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
        int userInput = 0;
        do {
            userInput = getUserInput();
            chooseOption(userInput);
        } while (userInput != 0);
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
            case 0:
                System.out.println("Bye bye");
                break;
            case 1:
                newBookList();
                break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private void newBookList() {
        BookRepository bookList = new BookRepository();
        System.out.println(bookList);
    }

    private int getUserInput() {
        showInputText();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        try {
            result = readInput(reader, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void showInputText() {
        System.out.print("\n");
        System.out.println("Insert a number to access a menu item");
    }

    private int readInput(BufferedReader reader, int result) throws IOException {
        String s = reader.readLine();
        if (s.length() > 0) {
            result = Integer.parseInt(s);
        }
        return result;
    }
}
