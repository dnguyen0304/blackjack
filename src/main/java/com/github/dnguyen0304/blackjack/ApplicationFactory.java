package com.github.dnguyen0304.blackjack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Random;

public class ApplicationFactory {

    private static final int CHIP_TOTAL = 50;
    private static final int DECK_COUNT = 8;
    private static final String DEALER_NAME = "Dealer";

    private final String[] args;

    public ApplicationFactory(String[] args) {
        this.args = args;
    }

    // How do you define a generic method signature for returning any object?
    public Application create() {
        BlackjackGameBuilder builder = new BlackjackGameBuilder();

        // Create the players.
        for (String name : this.args) {
            CardGamePlayer player = new BlackjackPlayer(name, ApplicationFactory.CHIP_TOTAL);
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

        // Create the asker.
        Reader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        Writer out = new PrintWriter(System.out);
        BlackjackAsker asker = new BlackjackAsker(in, out);

        // Create the dealer.
        CardGamePlayer player = new BlackjackPlayer(ApplicationFactory.DEALER_NAME, 0);
        Dealer dealer = new BlackjackDealer(player, shoe, shufflingMachine, asker);
        builder.withDealer(dealer);

        // Create the game.
        BlackjackGame game = builder.build();

        // Create the application.
        Application application = new Application(game);

        return application;
    }

}
