package com.github.dnguyen0304.blackjack;

public class DefaultShuffler implements Shuffler {

    private CardShuffleStrategy cardShuffleStrategy;
    private DeckShuffler deckShuffler;

    public DefaultShuffler(CardShuffleStrategy cardShuffleStrategy, DeckShuffler deckShuffler) {
        this.cardShuffleStrategy = cardShuffleStrategy;
        this.deckShuffler = deckShuffler;
    }

    @Override
    public void shuffle(Deck deck) {
        this.cardShuffleStrategy.shuffle(deck);
    }

    @Override
    public Deck shuffle(Deck... decks) {
        Deck shuffledDeck = this.deckShuffler.shuffle(decks);
        return shuffledDeck;
    }

}
