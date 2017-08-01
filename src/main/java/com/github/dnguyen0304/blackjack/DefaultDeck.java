package com.github.dnguyen0304.blackjack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultDeck implements Deck {

	private Deque<Card> cards;

	// This constructor must be called by all other alternate or overloaded
	// constructors.
	public DefaultDeck(Deque<Card> cards) {
		this.cards = cards;
	}

	public DefaultDeck() {
		this(new ArrayDeque<Card>());
	}

	/**
	 * The DefaultDeck exhibits LIFO behavior by default. In other words, the
	 * last card yielded from the iterable becomes the first one drawn from
	 * the deck.
	 *
	 * @param cards
	 * @return
	 */
	public static Deck fromIterable(Iterable<Card> cards) {
		Deck deck = new DefaultDeck();
		for (Card card : cards) {
			deck.add(card);
		}
		return deck;
	}

	public int getCount() {
		return cards.size();
	}

	public void add(Card card) {
		this.cards.addFirst(card);
	}

	public void addToBottom(Card card) {
		this.cards.addLast(card);
	}

	public Card draw() {
		return cards.removeFirst();
	}

	public Card drawFromBottom() {
		return cards.removeLast();
	}

	public void stackOnto(Deck other) {
		int count = other.getCount();
		for (int i = 0; i < count; i++) {
			Card card = other.draw();
			this.addToBottom(card);
		}
	}

	public Iterator<Card> iterator() {
		return new CardIterator();
	}

	// How do closures behave?
	private class CardIterator implements Iterator<Card> {

		public boolean hasNext() {
			return getCount() != 0;
		}

		public Card next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
			return draw();
		}

	}

}
