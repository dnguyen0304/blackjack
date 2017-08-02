package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

public class DefaultBlackjackTableBuilder {

    public static final int PLAYER_MINIMUM = 2;
    public static final int PLAYER_MAXIMUM = 6;

    private List<Position> positions;

    public DefaultBlackjackTableBuilder() {
        this.positions = new ArrayList<Position>();
    }

    public DefaultBlackjackTableBuilder withPosition(Position position) {
        this.positions.add(position);
        return this;
    }

    public BlackjackTable build() {
        this.validate();
        return new DefaultBlackjackTable(new DefaultTable(this.positions));
    }

    private void validate() throws IllegalStateException {
        if (this.positions.size() < DefaultBlackjackTableBuilder.PLAYER_MINIMUM ||
            this.positions.size() > DefaultBlackjackTableBuilder.PLAYER_MAXIMUM) {
                String pattern = "The number of positions must be between %d and %d, inclusive.";
                String message = String.format(pattern,
                                               DefaultBlackjackTableBuilder.PLAYER_MINIMUM,
                                               DefaultBlackjackTableBuilder.PLAYER_MAXIMUM);
            throw new IllegalStateException(message);
        }
    }

}
