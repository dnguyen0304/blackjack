package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGameBuilder {

    public static final int PLAYER_MINIMUM = 2;
    public static final int PLAYER_MAXIMUM = 6;

    private List<DealablePosition> positions;

    public BlackjackGameBuilder() {
        this.positions = new ArrayList<DealablePosition>();
    }

    public BlackjackGameBuilder withPosition(DealablePosition position) {
        this.positions.add(position);
        return this;
    }

    public BlackjackGame build() {
        this.validate();
        return new BlackjackGame(this.positions);
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
