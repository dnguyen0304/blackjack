package com.github.dnguyen0304.blackjack;

public class DeckShuffleStrategies {

    public static DeckShuffleStrategy stackOnto() {
        return new StackOntoDeckShuffleStrategy();
    }

    private static class StackOntoDeckShuffleStrategy implements DeckShuffleStrategy {

        @Override
        public Deck shuffle(Deck... decks) {
            Deck deck = decks[0];
            for (int i = 1; i < decks.length; i++) {
                deck.stackOnto(decks[i]);
            }
            return deck;
        }

    }

}
