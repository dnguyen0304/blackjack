package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BlackjackGameTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetPlayerCount() {
        List<DealablePosition> positions = new ArrayList<DealablePosition>();
        DealablePosition position = new DealablePosition();
        positions.add(position);
        BlackjackGame game = new BlackjackGame(positions);
        assertEquals(0, game.getPlayerCount());
    }

    @Test
    public void testSetDealer() {
        BlackjackGame game = new BlackjackGameBuilder()
            .withPosition(new DealablePosition())
            .withPosition(new DealablePosition())
            .build();
        game.setDealer(null);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void testSetDealerNoOpenPositions() {
        List<DealablePosition> positions = new ArrayList<DealablePosition>();
        BlackjackGame game = new BlackjackGame(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

    @Test
    public void testAddPlayer() {
        List<DealablePosition> positions = new ArrayList<DealablePosition>();
        DealablePosition position = new DealablePosition();
        positions.add(position);
        BlackjackGame game = new BlackjackGame(positions);
        game.addPlayer(null);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void testAddPlayerNoOpenPositions() {
        List<DealablePosition> positions = new ArrayList<DealablePosition>();
        BlackjackGame game = new BlackjackGame(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

}
