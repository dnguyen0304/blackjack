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
        Game game = new DefaultGame(positions);
        this.exception.expect(IllegalStateException.class);
        game.addPlayer(null);
    }

}
