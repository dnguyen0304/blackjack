package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultTableTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddPlayer() {
        List<Position> positions = new ArrayList<Position>();
        Position position = new DefaultPosition();
        positions.add(position);
        Table table = new DefaultTable(positions);
        Player player = new DefaultPlayer(null);
        table.addPlayer(player);
    }

    @Test
    public void testAddPlayerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        Table table = new DefaultTable(positions);
        Player player = new DefaultPlayer(null);
        this.exception.expect(IllegalStateException.class);
        table.addPlayer(player);
    }

}
