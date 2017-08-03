package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultBlackjackGameTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testSetDealer() {
        BlackjackTable game = new DefaultBlackjackGameBuilder()
            .withPosition(new DefaultPosition())
            .withPosition(new DefaultPosition())
            .build();
        game.setDealer(null);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void testSetDealerNoOpenPositions() {
        List<Position> positions = new ArrayList<Position>();
        Table game = new DefaultTable(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

}
