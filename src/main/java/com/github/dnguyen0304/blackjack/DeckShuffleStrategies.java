package com.github.dnguyen0304.blackjack;

public class DeckShuffleStrategies {

    public static DeckShuffler stackOnto() {
        return new StackOntoDeckShuffleStrategy();
    }

    private static class StackOntoDeckShuffleStrategy implements DeckShuffler {

        @Override
        public Deck shuffle(Deck... decks) {
            Deck base = decks[0];
            for (int i = 1; i < decks.length; i++) {
                decks[i].stackOnto(base);
            }
            return base;
        }

    }

}
