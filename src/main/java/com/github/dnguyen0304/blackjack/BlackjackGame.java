package com.github.dnguyen0304.blackjack;

import java.util.List;

public class BlackjackGame {

    private List<DealablePosition> positions;
    private Dealer dealer;

    public BlackjackGame(List<DealablePosition> positions, Dealer dealer) {
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
