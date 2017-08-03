package com.github.dnguyen0304.blackjack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deck implements Drawable {

    private Deque<BlackjackCard> cards;

    // This constructor must be called by all other alternate or overloaded
    // constructors.
    public Deck(Deque<BlackjackCard> cards) {
        this.cards = cards;
    }

    public Deck() {
        this(new ArrayDeque<BlackjackCard>());
    }

    /**
     * The DefaultDeck exhibits LIFO behavior by default. In other words, the last
     * card yielded from the iterable becomes the first one drawn from the deck.
     *
     * @param cards
     * @return
     */
    public static Deck fromIterable(Iterable<BlackjackCard> cards) {
        Deck deck = new Deck();
        for (BlackjackCard card : cards) {
            deck.add(card);
        }
        return deck;
    }

    public static Deck standard52() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                // Should an abstract factory be used here?
                BlackjackCard card = new BlackjackCard(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    public int getCount() {
        return cards.size();
    }

    public void add(BlackjackCard card) {
        this.cards.addFirst(card);
    }

    public void addToBottom(BlackjackCard card) {
        this.cards.addLast(card);
    }

    @Override
    public BlackjackCard draw() {
        return cards.removeFirst();
    }

    public BlackjackCard drawFromBottom() {
        return cards.removeLast();
    }

    public void stackOnto(Deck base) {
        int count = this.getCount();
        for (int i = 0; i < count; i++) {
            BlackjackCard card = this.drawFromBottom();
            base.add(card);
        }
    }

}
