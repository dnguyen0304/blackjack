package com.github.dnguyen0304.blackjack;

import java.util.List;

public class DefaultTable implements Table {

    private List<Position> positions;

    public DefaultTable(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public int getPlayerCount() {
        return this.positions.size();
    }

    @Override
    public void addPlayer(Player player) throws IllegalStateException {
        Position position = this.nextOpenPosition();
        position.setPlayer(player);
    }

    private Position nextOpenPosition() throws IllegalStateException {
        for (Position position : this.positions) {
            if (position.isOpen()) {
                return position;
            }
        }
        String message = "This table is full.";
        throw new IllegalStateException(message);
    }

}
