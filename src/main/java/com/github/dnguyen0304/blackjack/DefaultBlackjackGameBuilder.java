package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

public class DefaultBlackjackGameBuilder {

    public static final int PLAYER_MINIMUM = 2;
    public static final int PLAYER_MAXIMUM = 6;

    private List<Position> positions;

    public DefaultBlackjackGameBuilder() {
        this.positions = new ArrayList<Position>();
    }

    public DefaultBlackjackGameBuilder withPosition(Position position) {
        this.positions.add(position);
        return this;
    }

    public BlackjackGame build() {
        this.validate();
        return new DefaultBlackjackGame(new DefaultTable(this.positions));
    }

    private void validate() throws IllegalStateException {
        if (this.positions.size() < DefaultBlackjackGameBuilder.PLAYER_MINIMUM ||
            this.positions.size() > DefaultBlackjackGameBuilder.PLAYER_MAXIMUM) {
                String pattern = "The number of positions must be between %d and %d, inclusive.";
                String message = String.format(pattern,
                                               DefaultBlackjackGameBuilder.PLAYER_MINIMUM,
                                               DefaultBlackjackGameBuilder.PLAYER_MAXIMUM);
            throw new IllegalStateException(message);
        }
    }

}
