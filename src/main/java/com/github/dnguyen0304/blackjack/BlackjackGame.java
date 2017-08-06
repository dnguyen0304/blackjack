package com.github.dnguyen0304.blackjack;

import java.util.List;

public class BlackjackGame {

    private DealablePosition dealerPosition;
    private DealablePosition firstPosition;
    private List<DealablePosition> otherPositions;

    public BlackjackGame(DealablePosition dealerPosition,
                         DealablePosition firstPosition,
                         List<DealablePosition> otherPositions) {
        this.dealerPosition = dealerPosition;
        this.firstPosition = firstPosition;
        this.otherPositions = otherPositions;
    }

    public int countPlayers() {
        int count = BlackjackGameBuilder.PLAYER_MINIMUM;
        for (DealablePosition position : this.otherPositions) {
            if (!position.isOpen()) {
                count += 1;
            }
        }
        return count;
    }

    public void play() {

    }

}
