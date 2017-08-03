package com.github.dnguyen0304.blackjack;

import java.util.List;

public class DefaultGame implements Game {

    private List<Position> positions;
    private int playerCount;

    public DefaultGame(List<Position> positions) {
        this.positions = positions;
        this.playerCount = 0;
    }

    @Override
    public int getPlayerCount() {
        return this.playerCount;
    }

    @Override
    public void addPlayer(Player player) throws IllegalStateException {
        Position position = this.nextOpenPosition();
        position.setPlayer(player);
        this.playerCount++;
    }

    private Position nextOpenPosition() throws IllegalStateException {
        for (Position position : this.positions) {
            if (position.isOpen()) {
                return position;
            }
        }
        String message = "This game is full.";
        throw new IllegalStateException(message);
    }

}
