package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class CollectionsCardShuffleStrategyTest {

    @Test
    public void testShuffleCount() {
        long seed = 0L;
        Random random = new Random(seed);
        CardShuffler shuffler = CardShuffleStrategies.collections(random);
        Deck deck = Deck.standard52();

        int originalCount = deck.getCount();
        Deck shuffledDeck = shuffler.shuffle(deck);
        assertEquals(originalCount, shuffledDeck.getCount());
    }

}
