package com.github.dnguyen0304.blackjack;

public class DefaultPlayer implements Player {

    private String name;
    private int chipTotal;

    public DefaultPlayer(String name) {
        this.name = name;
        this.chipTotal = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getChipTotal() {
        return this.chipTotal;
    }

    @Override
    public void setChipTotal(int chipTotal) {
        this.chipTotal = chipTotal;
    }

}
