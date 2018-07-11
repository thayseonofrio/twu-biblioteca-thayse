package com.twu.biblioteca.model;

public class Rating {
    private int value;

    public Rating(int value) {
        validateValue(value);
    }

    private void validateValue(int value) {
        if (value >= 1 && value <= 10) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 10");
        }
    }

    public int getValue() {
        return value;
    }
}
