package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGameBuilder {

    public static final int PLAYER_MINIMUM = 2;
    public static final int PLAYER_MAXIMUM = 6;

    private DealablePositionFactory positionFactory;
    private List<DealablePosition> positions;
    private Dealer dealer;

    /**
     * This constructor must be called by all other alternate or overloaded
     * constructors.
     *
     * @param positionFactory Factory for creating positions.
     * @param positions List of positions in the game.
     */
    public BlackjackGameBuilder(DealablePositionFactory positionFactory, List<DealablePosition> positions) {
        this.positionFactory = positionFactory;
        this.positions = positions;
    }

    public BlackjackGameBuilder(DealablePositionFactory positionFactory) {
        this(positionFactory, new ArrayList<DealablePosition>());
    }

    // TODO Change to build a game with a fixed number of positions.

    public void withPlayer(Player player) {
        this.withPlayer(player, PlayerType.SIMPLE);
    }

    // TODO Define a build step.
    public void withDealer(Dealer dealer) {
        this.withPlayer(dealer, PlayerType.DEALER);
        this.dealer = dealer;
    }

    private void withPlayer(Player player, PlayerType type) {
        DealablePosition position = this.positionFactory.create();
        position.setPlayer(player, type);
        this.positions.add(position);
    }

    public BlackjackGame build() {
        this.validate();
        return new BlackjackGame(this.positions, this.dealer);
    }

    private void validate() throws IllegalStateException {
        if (this.positions.size() < BlackjackGameBuilder.PLAYER_MINIMUM ||
            this.positions.size() > BlackjackGameBuilder.PLAYER_MAXIMUM) {
                String pattern = "The number of positions must be between %d and %d, inclusive.";
                String message = String.format(pattern,
                                               BlackjackGameBuilder.PLAYER_MINIMUM,
                                               BlackjackGameBuilder.PLAYER_MAXIMUM);
            throw new IllegalStateException(message);
        }
    }

}
