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
            Player player = new Player(name);
            builder.withPlayer(player);
        }

        // Create the dealer.
        Player dealer = new Player(ApplicationFactory.DEALER_NAME);
        builder.withPlayer(dealer);

        // Create the game.
        BlackjackGame game = builder.build();

        // Create the application.
        Application application = new Application(game);

        return application;
    }

}
