package com.github.dnguyen0304.blackjack;

public class DefaultCard implements Card {

    private final Rank rank;
    private final Suit suit;

    public DefaultCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

}
