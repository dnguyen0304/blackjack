package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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

    private Iterator<DealablePosition> createAllPositionIterator() {
        List<DealablePosition> positions = new ArrayList<DealablePosition>();
        positions.add(this.firstPosition);
        positions.addAll(this.otherPositions);
        positions.add(this.dealerPosition);
        Iterator<DealablePosition> positionIterator = new PositionIterator(positions);
        return positionIterator;
    }

    // How do closures behave?
    private class PositionIterator implements Iterator<DealablePosition> {

        private List<DealablePosition> positions;
        private int i = 0;

        public PositionIterator(List<DealablePosition> positions) {
            this.positions = positions;
        }

        @Override
        public boolean hasNext() {
            return i < this.positions.size();
        }

        @Override
        public DealablePosition next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            DealablePosition position = this.positions.get(this.i);
            this.i++;
            return position;
        }

    }

}
