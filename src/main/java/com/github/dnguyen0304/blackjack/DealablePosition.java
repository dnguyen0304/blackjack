package com.github.dnguyen0304.blackjack;

public class DealablePosition implements Comparable<DealablePosition> {

    private Player player;
    private BlackjackHand hand;

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BlackjackHand getHand() {
        return this.hand;
    }

    public Boolean isOpen() {
        return this.player == null;
    }

    @Override
    public int compareTo(DealablePosition other) {
        return this.getHand().compareTo(other.getHand());
    }

}
