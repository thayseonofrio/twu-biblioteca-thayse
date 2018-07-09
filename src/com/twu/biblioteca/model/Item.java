package com.twu.biblioteca.model;

public abstract class Item {
    protected String title;
    protected int year;
    protected boolean borrowed;
    public Item(String title, int year) {
        this.title = title;
        this.year = year;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

}
