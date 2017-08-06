package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DealablePositionTest {

    @Test
    public void testIsOpen() {
        DefaultPosition position = new DefaultPosition(null);
        assertTrue(position.isOpen());
    }

    @Test
    public void testIsNotOpen() {
        DefaultPosition position = new DefaultPosition(null);
        position.setPlayer(new GamePlayer(null));
        assertTrue(!position.isOpen());
    }

}
