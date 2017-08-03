package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DeckTest {

    private BlackjackCard topCard;
    private BlackjackCard bottomCard;
    private Deque<BlackjackCard> cards;
    private Deck deck;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.topCard = new BlackjackCard(Rank.ACE, Suit.SPADES);
        this.bottomCard = new BlackjackCard(Rank.TWO, Suit.SPADES);
        this.cards = new ArrayDeque<BlackjackCard>();
        // This top card must be added to the deque first because the
        // DefaultDeck exhibits LIFO behavior by default. This pattern is
        // specifically for testing. The add method should be preferred
        // otherwise.
        this.cards.add(this.topCard);
        this.cards.add(this.bottomCard);
        this.deck = new Deck(this.cards);
    }

    @Test
    public void testFromIterable() {
        Iterable<BlackjackCard> cards = new ArrayList<BlackjackCard>();
        Deck deck = Deck.fromIterable(cards);
        assertEquals(0, deck.getCount());
    }

    @Test
    public void testFromIterableIsLifo() {
        List<BlackjackCard> cards = new ArrayList<BlackjackCard>(this.cards);
        Deck deck = Deck.fromIterable(cards);

        for (int i = cards.size() - 1; i > 0; i--) {
            assertEquals(cards.get(i).getRank(), deck.draw().getRank());
        }
    }

    @Test
    public void testStandard52Count() {
        int expectedCount = Rank.values().length * Suit.values().length;
        Deck deck = Deck.standard52();
        assertEquals(expectedCount, deck.getCount());
    }

    @Test
    public void testStandard52UniqueRankCount() {
        Set<Rank> uniqueRanks = new HashSet<Rank>();
        Deck deck = Deck.standard52();
        try {
            while (true) {
                BlackjackCard card = deck.draw();
                uniqueRanks.add(card.getRank());
            }
        } catch (NoSuchElementException e) {
            // Don't do anything.
        }
        assertEquals(Rank.values().length, uniqueRanks.size());
    }

    @Test
    public void testStandard52UniqueSuitCount() {
        Set<Suit> uniqueSuits = new HashSet<Suit>();
        Deck deck = Deck.standard52();
        try {
            while (true) {
                BlackjackCard card = deck.draw();
                uniqueSuits.add(card.getSuit());
            }
        } catch (NoSuchElementException e) {
            // Don't do anything.
        }
        assertEquals(Suit.values().length, uniqueSuits.size());
    }

    @Test
    public void testGetCount() {
        assertEquals(this.cards.size(), this.deck.getCount());
    }

    @Test
    public void testAdd() {
        int originalCount = this.deck.getCount();
        BlackjackCard card = new BlackjackCard(Rank.ACE, null);
        this.deck.add(card);
        assertEquals(originalCount + 1, this.deck.getCount());
        assertEquals(card.getRank(), this.deck.draw().getRank());
    }

    @Test
    public void testAddToBottom() {
        int originalCount = this.deck.getCount();
        BlackjackCard card = new BlackjackCard(Rank.ACE, null);
        this.deck.addToBottom(card);
        assertEquals(originalCount + 1, this.deck.getCount());
        assertEquals(card.getRank(), this.deck.drawFromBottom().getRank());
    }

    @Test
    public void testDraw() {
        BlackjackCard card = deck.draw();
        assertEquals(this.topCard.getRank(), card.getRank());
        assertEquals(this.topCard.getSuit(), card.getSuit());
    }

    @Test
    public void testDrawWhenEmpty() {
        Deck deck = new Deck();
        this.exception.expect(NoSuchElementException.class);
        deck.draw();
    }

    @Test
    public void testDrawFromBottom() {
        BlackjackCard card = deck.drawFromBottom();
        assertEquals(this.bottomCard.getRank(), card.getRank());
        assertEquals(this.bottomCard.getSuit(), card.getSuit());
    }

    @Test
    public void testDrawFromBottomWhenEmpty() {
        Deck deck = new Deck();
        this.exception.expect(NoSuchElementException.class);
        deck.drawFromBottom();
    }

    @Test
    public void testStackOnto() {
        int originalCount = this.cards.size();
        Deque<BlackjackCard> cards = new ArrayDeque<BlackjackCard>(this.cards);
        Deck base = new Deck(cards);
        this.deck.stackOnto(base);
        assertEquals(0, this.deck.getCount());
        assertEquals(originalCount * 2, base.getCount());
    }

    @Test
    public void testStackOntoIsOrdered() {
        BlackjackCard topCard = new BlackjackCard(Rank.THREE, null);
        BlackjackCard bottomCard = new BlackjackCard(Rank.FOUR, null);
        Deque<BlackjackCard> cards = new ArrayDeque<BlackjackCard>();
        cards.add(topCard);
        cards.add(bottomCard);
        Deck base = new Deck(cards);

        this.deck.stackOnto(base);

        assertEquals(Rank.ACE, base.draw().getRank());
        assertEquals(Rank.TWO, base.draw().getRank());
        assertEquals(Rank.THREE, base.draw().getRank());
        assertEquals(Rank.FOUR, base.draw().getRank());
    }

}
