package com.github.dnguyen0304.blackjack;

public class DefaultDealer implements Player {

    private Player player;

    public DefaultDealer(Player player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return this.player.getName();
    }

    @Override
    public int getChipTotal() {
        return this.player.getChipTotal();
    }

    @Override
    public void setChipTotal(int chipTotal) {
        this.player.setChipTotal(chipTotal);
    }

}
