package com.github.dnguyen0304.blackjack;

public class ShufflingMachine implements CardShuffler, DeckShuffler {

    private CardShuffler cardShuffler;
    private DeckShuffler deckShuffler;

    public ShufflingMachine(CardShuffler cardShuffler, DeckShuffler deckShuffler) {
        this.cardShuffler = cardShuffler;
        this.deckShuffler = deckShuffler;
    }

    @Override
    public void shuffle(Deck deck) {
        this.cardShuffler.shuffle(deck);
    }

    @Override
    public Deck shuffle(Deck... decks) {
        Deck shuffledDeck = this.deckShuffler.shuffle(decks);
        return shuffledDeck;
    }

}
