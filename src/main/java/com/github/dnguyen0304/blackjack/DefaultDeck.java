package com.github.dnguyen0304.blackjack;

import java.util.ArrayDeque;
import java.util.Deque;

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
     * The DefaultDeck exhibits LIFO behavior by default. In other words, the last
     * card yielded from the iterable becomes the first one drawn from the deck.
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

    public static Deck standard52() {
        Deck deck = new DefaultDeck();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new DefaultCard(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public void add(Card card) {
        this.cards.addFirst(card);
    }

    @Override
    public void addToBottom(Card card) {
        this.cards.addLast(card);
    }

    @Override
    public Card draw() {
        return cards.removeFirst();
    }

    @Override
    public Card drawFromBottom() {
        return cards.removeLast();
    }

    @Override
    public void stackOnto(Deck other) {
        int count = other.getCount();
        for (int i = 0; i < count; i++) {
            Card card = other.draw();
            this.addToBottom(card);
        }
    }

}
