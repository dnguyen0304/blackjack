package com.github.dnguyen0304.blackjack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BlackjackGameBuilderTest {

    private BlackjackGameBuilder builder;
    private CardGamePlayer player;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.builder = new BlackjackGameBuilder();
        this.player = new BlackjackPlayer(null, null);
    }

    @Test
    public void testBuild() {
        for (int i = 0; i < BlackjackGameBuilder.PLAYER_MINIMUM; i++) {
            this.builder.withPlayer(this.player);
        }
        this.builder.build();
    }

    @Test
    public void testBuildTooFewPlayers() {
        this.exception.expect(IllegalStateException.class);
        this.builder.build();
    }

    @Test
    public void testBuildTooManyPlayers() {
        for (int i = 0; i < BlackjackGameBuilder.PLAYER_MAXIMUM + 1; i++) {
            this.builder.withPlayer(this.player);
        }
        this.exception.expect(IllegalStateException.class);
        this.builder.build();
    }

}
