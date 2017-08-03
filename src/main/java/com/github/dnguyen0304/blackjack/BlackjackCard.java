package com.github.dnguyen0304.blackjack;

public class BlackjackCard {

    private final Rank rank;
    private final Suit suit;

    public BlackjackCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

}
