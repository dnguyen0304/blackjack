package com.github.dnguyen0304.blackjack;

/**
 * This strategy provides the algorithm for shuffling a single deck.
 *
 * Decks are shuffled in-place.
 *
 * @author Duy Nguyen
 * @see DeckShuffler
 */
public interface CardShuffler {

    // Should this specify a return value?
    public void shuffle(Deck deck);

}
