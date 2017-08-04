package com.github.dnguyen0304.blackjack;

import java.util.List;

public class BlackjackGame {

    private List<DealablePosition> positions;
    private Player dealer;

    public BlackjackGame(List<DealablePosition> positions, Player dealer) {
        this.positions = positions;
        this.dealer = dealer;
    }

    public int countPlayers() {
        int count = 0;
        for (DealablePosition position : this.positions) {
            if (!position.isOpen()) {
                count += 1;
            }
        }
        return count;
    }

    public void play() {

    }

}
