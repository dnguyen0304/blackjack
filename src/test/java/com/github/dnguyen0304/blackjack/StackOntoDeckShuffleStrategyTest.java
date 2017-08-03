package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StackOntoDeckShuffleStrategyTest {

    private DeckShuffler strategy;
    private List<Card> cards;
    private Deck deck;
    private Deck other;

    @Before
    public void setUp() {
        this.strategy = DeckShuffleStrategies.stackOnto();

        this.cards = new ArrayList<Card>();
        this.cards.add(new Card(Rank.FOUR, null));
        this.cards.add(new Card(Rank.THREE, null));
        this.cards.add(new Card(Rank.TWO, null));
        this.cards.add(new Card(Rank.ACE, null));

        this.deck = new DefaultDeck();
        this.other = new DefaultDeck();

        for (int i = 0; i < this.cards.size(); i++) {
            Card card = this.cards.get(i);
            if (i < this.cards.size() / 2) {
                this.deck.add(card);
            } else {
                this.other.add(card);
            }
        }
    }

    @Test
    public void testShuffle() {
        Deck shuffledDeck = this.strategy.shuffle(deck, other);
        assertEquals(this.cards.size(), shuffledDeck.getCount());
    }

    @Test
    public void testStackOntoIsOrdered() {
        Deck shuffledDeck = this.strategy.shuffle(deck, other);
        int count = shuffledDeck.getCount();
        for (int i = count - 1; i > 0; i--) {
            assertEquals(this.cards.get(i).getRank(), shuffledDeck.draw().getRank());
        }
    }

}
