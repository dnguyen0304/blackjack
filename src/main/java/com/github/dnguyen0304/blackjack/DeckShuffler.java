package com.github.dnguyen0304.blackjack;

/**
 * This strategy provides the algorithm for shuffling multiple decks together.
 *
 * @author Duy Nguyen
 * @see CardShuffleStrategy
 */
public interface DeckShuffler {

    public Deck shuffle(Deck... decks);

}
