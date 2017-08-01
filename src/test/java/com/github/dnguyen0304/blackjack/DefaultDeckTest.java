package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultDeckTest {

	private Card topCard;
	private Card bottomCard;
	private Deque<Card> cards;
	private Deck deck;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		this.topCard = new DefaultCard(Rank.ACE, Suit.SPADES);
		this.bottomCard = new DefaultCard(Rank.TWO, Suit.SPADES);
		this.cards = new ArrayDeque<Card>();
		// This top card must be added to the deque first because the
		// DefaultDeck exhibits LIFO behavior by default. This pattern is
		// specifically for testing. The add method should be preferred
		// otherwise.
		this.cards.add(this.topCard);
		this.cards.add(this.bottomCard);
		this.deck = new DefaultDeck(this.cards);
	}

	@Test
	public void testFromIterable() {
		Iterable<Card> cards = new ArrayList<Card>();
		Deck deck = DefaultDeck.fromIterable(cards);
		assertEquals(0, deck.getCount());
	}

	@Test
	public void testFromIterableIsLifo() {
		List<Card> cards = new ArrayList<Card>(this.cards);
		Deck deck = DefaultDeck.fromIterable(cards);

		for (int i = cards.size() - 1; i > 0; i--) {
			assertEquals(cards.get(i).getRank(), deck.draw().getRank());
		}
	}

	@Test
	public void testGetCount() {
		assertEquals(this.cards.size(), this.deck.getCount());
	}

	@Test
	public void testAdd() {
		int currentCount = this.deck.getCount();
		Card card = new DefaultCard(Rank.ACE, null);
		this.deck.add(card);
		assertEquals(currentCount + 1, this.deck.getCount());
		assertEquals(card.getRank(), this.deck.draw().getRank());
	}

	@Test
	public void testAddToBottom() {
		int currentCount = this.deck.getCount();
		Card card = new DefaultCard(Rank.ACE, null);
		this.deck.addToBottom(card);
		assertEquals(currentCount + 1, this.deck.getCount());
		assertEquals(card.getRank(), this.deck.drawFromBottom().getRank());
	}

	@Test
	public void testDraw() {
		Card card = deck.draw();
		assertEquals(this.topCard.getRank(), card.getRank());
		assertEquals(this.topCard.getSuit(), card.getSuit());
	}

	@Test
	public void testDrawWhenEmpty() {
		Deck deck = new DefaultDeck();
		exception.expect(NoSuchElementException.class);
		deck.draw();
	}

	@Test
	public void testDrawFromBottom() {
		Card card = deck.drawFromBottom();
		assertEquals(this.bottomCard.getRank(), card.getRank());
		assertEquals(this.bottomCard.getSuit(), card.getSuit());
	}

	@Test
	public void testDrawFromBottomWhenEmpty() {
		Deck deck = new DefaultDeck();
		exception.expect(NoSuchElementException.class);
		deck.drawFromBottom();
	}

	@Test
	public void testStackOnto() {
		int originalCount = this.cards.size();
		Deque<Card> cards = new ArrayDeque<Card>(this.cards);
		Deck other = new DefaultDeck(cards);
		this.deck.stackOnto(other);
		assertEquals(originalCount * 2, this.deck.getCount());
	}

	@Test
	public void testStackOntoIsOrdered() {
		Card topCard = new DefaultCard(Rank.THREE, null);
		Card bottomCard = new DefaultCard(Rank.FOUR, null);
		Deque<Card> cards = new ArrayDeque<Card>();
		cards.add(topCard);
		cards.add(bottomCard);
		Deck other = new DefaultDeck(cards);

		this.deck.stackOnto(other);

		assertEquals(Rank.ACE, this.deck.draw().getRank());
		assertEquals(Rank.TWO, this.deck.draw().getRank());
		assertEquals(Rank.THREE, this.deck.draw().getRank());
		assertEquals(Rank.FOUR, this.deck.draw().getRank());
	}

	@Test
	public void testIterator() {
		// Remove the top card to simplify testing.
		this.deck.draw();

		for (Card card : this.deck) {
			assertEquals(this.bottomCard.getRank(), card.getRank());
			assertEquals(this.bottomCard.getSuit(), card.getSuit());
		}
	}

}