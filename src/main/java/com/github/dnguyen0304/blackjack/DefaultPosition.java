package com.github.dnguyen0304.blackjack;

public class DefaultPosition implements Position {

    private Player player;

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

}
