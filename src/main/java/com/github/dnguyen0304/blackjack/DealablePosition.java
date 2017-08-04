package com.github.dnguyen0304.blackjack;

public class DealablePosition {

    private Player player;

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Boolean isOpen() {
        return this.player == null;
    }

}
