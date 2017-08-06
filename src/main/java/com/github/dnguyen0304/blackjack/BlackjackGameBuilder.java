package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGameBuilder {

    public static final int PLAYER_MINIMUM = 2;
    public static final int PLAYER_MAXIMUM = 6;

    private Dealer dealer;
    private DefaultPlayer firstPlayer;
    private List<DefaultPlayer> otherPlayers;

    /**
     * This constructor must be called by all other alternate or overloaded
     * constructors.
     */
    private BlackjackGameBuilder(List<DefaultPlayer> otherPlayers) {
        this.otherPlayers = otherPlayers;
    }

    public BlackjackGameBuilder() {
        this(new ArrayList<DefaultPlayer>());
    }

    // TODO Change to build a game with a fixed number of positions.

    // TODO Define a build step.
    public void withDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void withPlayer(Player player) {
        if (this.firstPlayer == null) {
            this.firstPlayer = player;
        } else {
            this.otherPlayers.add(player);
        }
    }

    public BlackjackGame build() {
        this.validate();
        return new BlackjackGame(this.dealer, this.firstPlayer, this.otherPlayers);
    }

    private void validate() throws IllegalStateException {
        int count = this.otherPlayers.size();
        if (this.dealer != null) {
            count += 1;
        }
        if (this.firstPlayer != null) {
            count += 1;
        }
        if (count < BlackjackGameBuilder.PLAYER_MINIMUM ||
            count > BlackjackGameBuilder.PLAYER_MAXIMUM) {
                String pattern = "The number of positions must be between %d and %d, inclusive.";
                String message = String.format(pattern,
                                               BlackjackGameBuilder.PLAYER_MINIMUM,
                                               BlackjackGameBuilder.PLAYER_MAXIMUM);
            throw new IllegalStateException(message);
        }
    }

}
