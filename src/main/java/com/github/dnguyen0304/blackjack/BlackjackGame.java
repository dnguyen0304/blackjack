package com.github.dnguyen0304.blackjack;

import java.util.List;

public class BlackjackGame {

    private List<DealablePosition> positions;
    private int playerCount;
    private Player dealer;

    public BlackjackGame(List<DealablePosition> positions) {
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
        DealablePosition position = this.nextOpenPosition();
        position.setPlayer(player);
        this.playerCount++;
    }

    private DealablePosition nextOpenPosition() throws IllegalStateException {
        for (DealablePosition position : this.positions) {
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
