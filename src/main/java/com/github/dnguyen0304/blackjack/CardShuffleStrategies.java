package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardShuffleStrategies {

    public static CardShuffleStrategy collections(Random random) {
        return new CollectionsCardShuffleStrategy(random);
    }

    private static class CollectionsCardShuffleStrategy implements CardShuffleStrategy {

        private Random random;

        public CollectionsCardShuffleStrategy(Random random) {
            this.random = random;
        }

        @Override
        public void shuffle(Deck deck) {
            // Create a temporary list where cards will be shuffled.
            List<Card> list = new ArrayList<Card>();
            int count = deck.getCount();
            for (int i = 0; i < count; i++) {
                Card card = deck.draw();
                list.add(card);
            }
            Collections.shuffle(list, this.random);
            // Add the cards back into the deck.
            for (Card card : list) {
                deck.add(card);
            }
        }

    }

}
