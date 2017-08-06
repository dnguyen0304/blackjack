package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DealablePositionTest {

    @Test
    public void testIsOpen() {
        DealablePosition position = new DealablePosition(null);
        assertTrue(position.isOpen());
    }

    @Test
    public void testIsNotOpen() {
        DealablePosition position = new DealablePosition(null);
        position.setPlayer(new GamePlayer(null));
        assertTrue(!position.isOpen());
    }

}
