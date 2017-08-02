package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackTableBuilder {

    public static final int PLAYER_MINIMUM = 2;
    public static final int PLAYER_MAXIMUM = 6;

    private List<Position> positions;

    public BlackjackTableBuilder() {
        this.positions = new ArrayList<Position>();
    }

    public BlackjackTableBuilder withPosition(Position position) {
        this.positions.add(position);
        return this;
    }

    public Table build() {
        this.validate();
        return new DefaultTable(this.positions);
    }

    private void validate() throws IllegalStateException {
        if (this.positions.size() < BlackjackTableBuilder.PLAYER_MINIMUM ||
            this.positions.size() > BlackjackTableBuilder.PLAYER_MAXIMUM) {
                String pattern = "The number of positions must be between %d and %d, inclusive.";
                String message = String.format(pattern,
                                               BlackjackTableBuilder.PLAYER_MINIMUM,
                                               BlackjackTableBuilder.PLAYER_MAXIMUM);
            throw new IllegalStateException(message);
        }
    }

}
