package com.github.dnguyen0304.blackjack;

public class DefaultPosition implements Comparable<DefaultPosition> {

    private BlackjackHand hand;
    private Player player;

    public DefaultPosition(BlackjackHand hand) {
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

    public void addToHand(BlackjackCard card) {
        this.hand.add(card);
    }

    @Override
    public int compareTo(DefaultPosition other) {
        // How can this access other instances' private fields?
        return this.hand.compareTo(other.hand);
    }

}
