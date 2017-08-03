package com.github.dnguyen0304.blackjack;

import java.util.List;

public class BlackjackGame {

    private List<Position> positions;
    private int playerCount;
    private Player dealer;

    public BlackjackGame(List<Position> positions) {
        this.positions = positions;
        this.playerCount = 0;
    }

    public int getPlayerCount() {
        return this.playerCount;
    }

    public void setDealer(Player dealer) {
        this.addPlayer(dealer);
        this.dealer = dealer;
    }

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

    public void play() {

    }

}
