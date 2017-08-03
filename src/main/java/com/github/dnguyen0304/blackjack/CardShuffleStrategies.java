package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        public void shuffle(Deck deck) {
            // Create a temporary list where cards will be shuffled.
            List<BlackjackCard> list = new ArrayList<BlackjackCard>();
            int count = deck.getCount();
            for (int i = 0; i < count; i++) {
                BlackjackCard card = deck.draw();
                list.add(card);
            }
            Collections.shuffle(list, this.random);
            // Add the cards back into the deck.
            for (BlackjackCard card : list) {
                deck.add(card);
            }
        }

    }

}
