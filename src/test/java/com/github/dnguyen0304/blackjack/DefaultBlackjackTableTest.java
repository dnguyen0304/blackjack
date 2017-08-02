package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultBlackjackTableTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testSetDealer() {
        BlackjackTable table = new DefaultBlackjackTableBuilder()
            .withPosition(new DefaultPosition())
            .withPosition(new DefaultPosition())
            .build();
        table.setDealer(null);
        assertEquals(1, table.getPlayerCount());
    }

    @Test
    public void testSetDealerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        Table table = new DefaultTable(positions);
        this.exception.expect(IllegalStateException.class);
        table.addPlayer(null);
    }

}
