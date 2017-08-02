package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultTableTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetPlayerCount() {
        List<Position> positions = new ArrayList<Position>();
        Position position = new DefaultPosition();
        positions.add(position);
        Table table = new DefaultTable(positions);
        assertEquals(0, table.getPlayerCount());
    }

    @Test
    public void testAddPlayer() {
        List<Position> positions = new ArrayList<Position>();
        Position position = new DefaultPosition();
        positions.add(position);
        Table table = new DefaultTable(positions);
        table.addPlayer(null);
        assertEquals(1, table.getPlayerCount());
    }

    @Test
    public void testAddPlayerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        Table table = new DefaultTable(positions);
        this.exception.expect(IllegalStateException.class);
        table.addPlayer(null);
    }

}
