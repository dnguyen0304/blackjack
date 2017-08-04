package com.github.dnguyen0304.blackjack;

import java.util.Random;

public class ApplicationFactory {

    private static final String DEALER_NAME = "Dealer";
    private static final int DECK_COUNT = 8;

    private final String[] args;

    public ApplicationFactory(String[] args) {
        this.args = args;
    }

    // How do you define a generic method signature for returning any object?
    public Application create() {
        DealablePositionFactory positionFactory = new DealablePositionFactory();
        BlackjackGameBuilder builder = new BlackjackGameBuilder(positionFactory);

        // Create the players.
        for (String name : this.args) {
            Player player = new GamePlayer(name);
            builder.withPlayer(player);
        }

        // Create the shoe.
        Deck shoe = Deck.standard52();
        for (int i = 0; i < ApplicationFactory.DECK_COUNT - 1; i++) {
            Deck deck = Deck.standard52();
            deck.stackOnto(shoe);
        }

        // Create the shuffling machine.
        long seed = System.nanoTime();
        Random random = new Random(seed);
        CardShuffler shufflingMachine = CardShuffleStrategies.collections(random);

        // Create the dealer.
        Player player = new GamePlayer(ApplicationFactory.DEALER_NAME);
        Dealer dealer = new BlackjackDealer(player, shoe, shufflingMachine);
        builder.withPlayer(dealer);

        // Create the game.
        BlackjackGame game = builder.build();

        // Create the application.
        Application application = new Application(game);

        return application;
    }

}
