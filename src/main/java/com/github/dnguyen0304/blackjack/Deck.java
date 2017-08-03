package com.github.dnguyen0304.blackjack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deck implements Drawable {

    private Deque<Card> cards;

    // This constructor must be called by all other alternate or overloaded
    // constructors.
    public Deck(Deque<Card> cards) {
        this.cards = cards;
    }

    public Deck() {
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
        Deck deck = new Deck();
        for (Card card : cards) {
            deck.add(card);
        }
        return deck;
    }

    public static Deck standard52() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                // A factory should be used here.
                Card card = new Card(rank, suit);
                deck.add(card);
            }
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

    @Override
    public Card draw() {
        return cards.removeFirst();
    }

    public Card drawFromBottom() {
        return cards.removeLast();
    }

    public void stackOnto(Deck base) {
        int count = this.getCount();
        for (int i = 0; i < count; i++) {
            Card card = this.drawFromBottom();
            base.add(card);
        }
    }

}
