package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultGameTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetPlayerCount() {
        List<Position> positions = new ArrayList<Position>();
        Position position = new DefaultPosition();
        positions.add(position);
        Game game = new DefaultGame(positions);
        assertEquals(0, game.getPlayerCount());
    }

    @Test
    public void testAddPlayer() {
        List<Position> positions = new ArrayList<Position>();
        Position position = new DefaultPosition();
        positions.add(position);
        Game game = new DefaultGame(positions);
        game.addPlayer(null);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void testAddPlayerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        Game game = new DefaultGame(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

}
