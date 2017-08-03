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
        List<Position> positions = new ArrayList<Position>();
        Position position = new Position();
        positions.add(position);
        BlackjackGame game = new BlackjackGame(positions);
        assertEquals(0, game.getPlayerCount());
    }

    @Test
    public void testSetDealer() {
        BlackjackGame game = new DefaultBlackjackGameBuilder()
            .withPosition(new Position())
            .withPosition(new Position())
            .build();
        game.setDealer(null);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void testSetDealerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        BlackjackGame game = new BlackjackGame(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

    @Test
    public void testAddPlayer() {
        List<Position> positions = new ArrayList<Position>();
        Position position = new Position();
        positions.add(position);
        BlackjackGame game = new BlackjackGame(positions);
        game.addPlayer(null);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void testAddPlayerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        BlackjackGame game = new BlackjackGame(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

}
