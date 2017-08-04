package com.github.dnguyen0304.blackjack;

public class DealablePosition implements Comparable<DealablePosition> {

    private BlackjackHand hand;
    private Player player;
    private PlayerType playerType;

    public DealablePosition(BlackjackHand hand) {
        this.hand = hand;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player, PlayerType type) {
        this.player = player;
        this.playerType = type;
    }

    public Boolean isOpen() {
        return this.player == null;
    }

    public Boolean isDealer() {
        return this.playerType == PlayerType.DEALER;
    }

    public void addToHand(BlackjackCard card) {
        this.hand.add(card);
    }

    @Override
    public int compareTo(DealablePosition other) {
        // How can this access other instances' private fields?
        return this.hand.compareTo(other.hand);
    }

}
