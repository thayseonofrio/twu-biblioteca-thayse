package com.twu.biblioteca;

import com.twu.biblioteca.model.UserSession;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.service.AuthenticationService;
import com.twu.biblioteca.service.CustomerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// TODO: view should only have access to service and not to repos
public class Menu {
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
        menu.put(7, "User Info");
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
                endSession();
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
            case 7:
                showUserInfo();
                break;
            default:
                System.out.println("\n ****** Select a valid option! ****** \n");
        }
    }
    private void initialize() {
        customerService = new CustomerService();
    }

    private void printBookList() {
        customerService.printBook();
    }

    private void printMovieList() { customerService.printMovie(); }

    private void checkoutBook() {
        if (UserSession.isLoggedIn()) {
            String result = "";
            System.out.println("\nInsert the name of the book to checkout: ");
            result = customerService.checkoutBook(getTitle());
            System.out.println(result);
        } else {
            requestLogin();
        }
    }

    private void returnBook() {
        if (UserSession.isLoggedIn()) {
            String result = "";
            result = customerService.returnBook();
            System.out.println(result);
        } else {
            requestLogin();
        }
    }

    private void checkoutMovie() {
        if (UserSession.isLoggedIn()) {
            String result = "";
            System.out.println("\nInsert the name of the movie to checkout: ");
            result = customerService.checkoutMovie(getTitle());
            System.out.println(result);
        } else {
            requestLogin();
        }
    }

    private void returnMovie() {
        if(UserSession.isLoggedIn()) {
            String result = "";
            result = customerService.returnMovie();
            System.out.println(result);
        } else {
            requestLogin();
        }
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
        System.out.println("\nInsert a number to access a menu item:");
    }

    private int readInput(BufferedReader reader, int result) throws IOException {
        String s = reader.readLine();
        if (s.length() > 0) {
            result = Integer.parseInt(s);
        }
        return result;
    }

    private void requestLogin() {
        System.out.println("\n ****** You must be logged in to perform this action. ****** \n");
        login();
    }

    private void login() {
        String password = "";
        String login= "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        login = getLoginInput(login, reader, "\nInsert Library Number:");
        password = getLoginInput(password, reader, "\nInsert Password:");
        authenticate(password, login);
    }

    private void authenticate(String password, String login) {
        AuthenticationService authenticationService = new AuthenticationService(login, password);
        boolean validation = authenticationService.verifyCredentials();
        if (!validation) {
            System.out.println("\nInvalid Login\n");
        } else {
            System.out.println(UserSession.getUser());
        }
    }

    private void showUserInfo() {
        if (UserSession.isLoggedIn()) {
            System.out.println("************************");
            System.out.println(UserSession.getUser());
            System.out.println("************************");
        } else {
            requestLogin();
        }
    }

    private String getLoginInput(String login, BufferedReader reader, String s) {
        System.out.println(s);
        try {
            login = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return login;
    }

    private void endSession() {
        UserSession.setUser(null);
        System.out.println("\n *** Bye bye *** \n");
    }
}
