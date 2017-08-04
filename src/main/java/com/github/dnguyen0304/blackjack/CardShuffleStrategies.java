package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class CardShuffleStrategies {

    public static CardShuffler collections(Random random) {
        return new CollectionsCardShuffleStrategy(random);
    }

    private static class CollectionsCardShuffleStrategy implements CardShuffler {

        private Random random;

        public CollectionsCardShuffleStrategy(Random random) {
            this.random = random;
        }

        @Override
        public Deck shuffle(Drawable cards) {
            List<BlackjackCard> list = new ArrayList<BlackjackCard>();
            try {
                BlackjackCard card = cards.draw();
                list.add(card);
            } catch (NoSuchElementException e) {
                // Don't do anything.
            }
            Collections.shuffle(list, this.random);
            // TODO Change this to use a factory.
            Deck deck = Deck.fromIterable(list);
            return deck;
        }

    }

}
