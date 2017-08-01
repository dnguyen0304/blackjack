package com.github.dnguyen0304.blackjack;

public interface Shuffler {

    // Should this specify a return value?
    public void shuffle(Deck deck);

    public Deck shuffle(Deck... decks);

}
