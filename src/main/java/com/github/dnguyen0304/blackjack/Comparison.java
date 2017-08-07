package com.github.dnguyen0304.blackjack;

public enum Comparison {

    LESS_THAN (-1),
    EQUAL_TO (0),
    GREATER_THAN (1);

    private final int value;

    private Comparison(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
