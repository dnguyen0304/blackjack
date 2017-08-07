package com.github.dnguyen0304.blackjack;

/**
 * This provides the algorithm for shuffling a single deck.
 *
 * @author Duy Nguyen
 */
public interface CardShuffler {

    public Deck shuffle(Drawable deck);

}
