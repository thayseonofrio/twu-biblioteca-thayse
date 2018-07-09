package com.twu.biblioteca;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.service.CustomerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    BookRepository bookRepository;
    MovieRepository movieRepository;
    CustomerService customerService;
    private HashMap<Integer, String> menu = new HashMap<Integer, String>();

    public Menu() {
        fillOptions();
        initialize();
        showMenuOptions();
        int userInput = 0;
        do {
            userInput = getUserInput();
            chooseOption(userInput);
        } while (userInput != 0);
    }

    public void fillOptions() {
        menu.put(0, "Quit");
        menu.put(1, "List Books");
        menu.put(2, "Checkout Book");
        menu.put(3, "Return Book");
        menu.put(4, "List Movies");
        menu.put(5, "Checkout Movie");
        menu.put(6, "Return Movie");
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
                printBookList();
                break;
            case 2:
                checkoutBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                printMovieList();
                break;
            case 5:
                checkoutMovie();
                break;
            case 6:
                returnMovie();
                break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private void initialize() {
        bookRepository = new BookRepository();
        movieRepository = new MovieRepository();
        customerService = new CustomerService(bookRepository, movieRepository);
    }

    private void printBookList() {
        System.out.println(bookRepository);
    }

    private void printMovieList() { System.out.println(movieRepository); }

    private void checkoutBook() {
        String result = "";
        System.out.println("Insert the name of the book to checkout: ");
        result = customerService.checkoutBook(getTitle());
        System.out.println(result);
    }

    private void returnBook() {
        String result = "";
        result = customerService.returnBook();
        System.out.println(result);
    }

    private void checkoutMovie() {
        String result = "";
        System.out.println("Insert the name of the movie to checkout: ");
        result = customerService.checkoutMovie(getTitle());
        System.out.println(result);
    }

    private void returnMovie() {
        String result = "";
        result = customerService.returnMovie();
        System.out.println(result);
    }

    private String getTitle() {
        String bookTitle = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            bookTitle = reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return bookTitle;
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
