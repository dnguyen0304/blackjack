package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BlackjackGame {

    private DefaultPosition dealerPosition;
    private DefaultPosition firstPosition;
    private List<DefaultPosition> otherPositions;

    public BlackjackGame(DefaultPosition dealerPosition,
                         DefaultPosition firstPosition,
                         List<DefaultPosition> otherPositions) {
        this.dealerPosition = dealerPosition;
        this.firstPosition = firstPosition;
        this.otherPositions = otherPositions;
    }

    public int countPlayers() {
        int count = BlackjackGameBuilder.PLAYER_MINIMUM;
        for (DefaultPosition position : this.otherPositions) {
            if (!position.isOpen()) {
                count += 1;
            }
        }
        return count;
    }

    public void play() {

    }

    private Iterator<DefaultPosition> createActivePositionIterator() {
        List<DefaultPosition> positions = new ArrayList<DefaultPosition>();
        positions.add(this.firstPosition);
        positions.addAll(this.otherPositions);
        positions.add(this.dealerPosition);
        positions = positions.stream()
                             .filter(DefaultPosition::isOpen)
                             .collect(Collectors.toCollection(ArrayList::new));
        Iterator<DefaultPosition> positionIterator = new PositionIterator(positions);
        return positionIterator;
    }

    // How do closures behave?
    private class PositionIterator implements Iterator<DefaultPosition> {

        private List<DefaultPosition> positions;
        private int i = 0;

        public PositionIterator(List<DefaultPosition> positions) {
            this.positions = positions;
        }

        @Override
        public boolean hasNext() {
            return i < this.positions.size();
        }

        @Override
        public DefaultPosition next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            DefaultPosition position = this.positions.get(this.i);
            this.i++;
            return position;
        }

    }

}
