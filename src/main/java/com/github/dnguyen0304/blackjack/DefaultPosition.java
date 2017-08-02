package com.github.dnguyen0304.blackjack;

public class DefaultPosition implements Position {

    private Player player;
    private int bet;

    @Override
    public Boolean isOpen() {
        return this.player == null;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int getBet() {
        return this.bet;
    }

    @Override
    public void setBet(int bet) {
        this.bet = bet;
    }

}
