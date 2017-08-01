package com.github.dnguyen0304.blackjack;

public class DefaultShoe implements Shoe {

    private Deck deck;

    public DefaultShoe(Deck deck) {
        this.deck = deck;
    }

    @Override
    public Card draw() {
        Card card = this.deck.draw();
        return card;
    }

}
