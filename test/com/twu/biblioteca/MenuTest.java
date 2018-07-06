package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Menu menu;

    @Before
    public void newInstance() throws IOException {
        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        Mockito.when(bufferedReader.readLine()).thenReturn("1");
        menu = new Menu();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void shouldCreateMenu() {
        Menu menu = new Menu();
        menu.fillOptions();
        assertEquals("List Books", menu.getMenu().get(1));
    }

    @Test
    public void shouldShowMenuOptions() {
        menu.showMenuOptions();
        assertEquals("1 - List Books\n", outContent.toString());
    }

// TODO: Como usar o mockito ????
//    @Test
//    public void shouldChooseOption() {
//        String userInput = "1";
//        BookList bookList = Mockito.mock(BookList.class);
//        Mockito.when(bookList.getBooks()).thenCallRealMethod();
//        menu.chooseOption(userInput);
//        Mockito.verify(bookList).getBooks();
//    }

    @Test
    public void shouldChooseOption() throws IOException {
        int userInput = 1;
        BookRepository bookList = new BookRepository();
        menu.chooseOption(1);
        assertEquals(bookList.toString(), outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
