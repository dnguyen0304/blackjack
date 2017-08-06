package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlackjackGameTest {

    private BlackjackGameBuilder builder;
    private CardGamePlayer player;
    private Dealer dealer;

    @Before
    public void setUp() {
        this.builder = new BlackjackGameBuilder();
        this.player = new BlackjackPlayer(null, 0);
        this.dealer = new BlackjackDealer(null, null, null, null);
    }

    @Test
    public void testCountPlayers() {
        for (int i = 0; i < BlackjackGameBuilder.PLAYER_MINIMUM; i++) {
            this.builder.withPlayer(this.player);
        }
        this.builder.withDealer(this.dealer);
        BlackjackGame game = this.builder.build();
        assertEquals(BlackjackGameBuilder.PLAYER_MINIMUM + 1, game.countPlayers());
    }

}
