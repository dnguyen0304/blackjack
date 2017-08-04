package com.github.dnguyen0304.blackjack;

/**
 * This provides the algorithm for shuffling a single deck.
 *
 * Decks are shuffled in-place.
 *
 * @author Duy Nguyen
 */
public interface CardShuffler {

    // Should this specify a return value?
    public void shuffle(Deck deck);

}
