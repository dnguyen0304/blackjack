package com.github.dnguyen0304.blackjack;

public class Position {

    private Player player;

    public Boolean isOpen() {
        return this.player == null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
