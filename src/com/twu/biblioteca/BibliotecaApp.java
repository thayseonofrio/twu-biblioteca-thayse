package com.twu.biblioteca;

public class BibliotecaApp {

    public BibliotecaApp() {
    }

    public static void main(String[] args) {
        System.out.println(getWelcomeMessage());
        Menu menu = new Menu();
    }

    public static String getWelcomeMessage() {
        return "Welcome!";
    }

}
