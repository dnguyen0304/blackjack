package com.github.dnguyen0304.blackjack;

public class Player {

    private String name;
    private int chipTotal;

    public Player(String name) {
        this.name = name;
        this.chipTotal = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getChipTotal() {
        return this.chipTotal;
    }

    public void setChipTotal(int chipTotal) {
        this.chipTotal = chipTotal;
    }

}
