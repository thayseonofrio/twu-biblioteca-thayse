package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
