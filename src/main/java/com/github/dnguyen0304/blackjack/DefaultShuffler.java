package com.github.dnguyen0304.blackjack;

public class DefaultShuffler implements Shuffler {

    private CardShuffleStrategy cardShuffleStrategy;
    private DeckShuffleStrategy deckShuffleStrategy;

    public DefaultShuffler(CardShuffleStrategy cardShuffleStrategy, DeckShuffleStrategy deckShuffleStrategy) {
        this.cardShuffleStrategy = cardShuffleStrategy;
        this.deckShuffleStrategy = deckShuffleStrategy;
    }

    @Override
    public void shuffle(Deck deck) {
        this.cardShuffleStrategy.shuffle(deck);
    }

    @Override
    public Deck shuffle(Deck... decks) {
        Deck shuffledDeck = this.deckShuffleStrategy.shuffle(decks);
        return shuffledDeck;
    }

}
