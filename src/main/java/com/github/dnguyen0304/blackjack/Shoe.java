package com.github.dnguyen0304.blackjack;

public class Shoe implements Drawable {

    private Deck deck;

    public Shoe() {
        // Constructing a Deck here is acceptable because it is a value object.
        // Should an abstract factory be used here?
        this.deck = new Deck();
    }

    public void add(Deck deck) {
        deck.stackOnto(this.deck);
    }

    @Override
    public BlackjackCard draw() {
        BlackjackCard card = this.deck.draw();
        return card;
    }

}
