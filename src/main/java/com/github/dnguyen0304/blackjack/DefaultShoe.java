package com.github.dnguyen0304.blackjack;

public class DefaultShoe implements Drawable, Shoe {

    private Deck deck;

    public DefaultShoe() {
        // Constructing a Deck here is acceptable because it is a value object.
        // Should an abstract factory be used here?
        this.deck = new Deck();
    }

    @Override
    public void add(Deck deck) {
        deck.stackOnto(this.deck);
    }

    @Override
    public Card draw() {
        Card card = this.deck.draw();
        return card;
    }

}
