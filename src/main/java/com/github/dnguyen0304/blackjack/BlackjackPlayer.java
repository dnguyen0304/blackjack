package com.github.dnguyen0304.blackjack;

public class BlackjackPlayer implements CardGamePlayer {

    private String name;
    private int chipTotal;
    private BlackjackHand hand;

    /**
     * This constructor must be called by all other alternate or overloaded
     * constructors.
     */
    private BlackjackPlayer(String name, int chipTotal, BlackjackHand hand) {
        this.name = name;
        this.chipTotal = chipTotal;
        this.hand = hand;
    }

    public BlackjackPlayer(String name, int chipTotal) {
        this(name, chipTotal, new BlackjackHand());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getChipTotal() {
        return this.chipTotal;
    }

    @Override
    public void setChipTotal(int chipTotal) {
        this.chipTotal = chipTotal;
    }

    @Override
    public BlackjackHand getHand() {
        return this.hand;
    }

    @Override
    public void addToHand(BlackjackCard card) {
        this.getHand().add(card);
    }

    @Override
    public int compareTo(CardGamePlayer other) {
        return this.getHand().compareTo(other.getHand());
    }

}
