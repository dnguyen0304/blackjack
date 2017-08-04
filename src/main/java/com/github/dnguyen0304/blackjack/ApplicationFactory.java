package com.github.dnguyen0304.blackjack;

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

        // Create the deck(s).
        Deck deck = Deck.standard52();
        for (int i = 0; i < ApplicationFactory.DECK_COUNT - 1; i++) {
            Deck other = Deck.standard52();
            other.stackOnto(deck);
        }

        // Create the dealer.
        Player player = new GamePlayer(ApplicationFactory.DEALER_NAME);
        Player dealer = new DealingPlayer(player, deck);
        builder.withPlayer(dealer);

        // Create the game.
        BlackjackGame game = builder.build();

        // Create the application.
        Application application = new Application(game);

        return application;
    }

}
