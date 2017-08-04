package com.github.dnguyen0304.blackjack;

public class DealablePosition implements Comparable<DealablePosition> {

    private BlackjackHand hand;
    private Player player;

    public DealablePosition(BlackjackHand hand) {
        this.hand = hand;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Boolean isOpen() {
        return this.player == null;
    }

    @Override
    public int compareTo(DealablePosition other) {
        // How can this access other instances' private fields?
        return this.hand.compareTo(other.hand);
    }

}
