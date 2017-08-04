package com.github.dnguyen0304.blackjack;

public class DealablePosition {

    private Player player;

    public DealablePosition(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Boolean isOpen() {
        return this.player == null;
    }

}
