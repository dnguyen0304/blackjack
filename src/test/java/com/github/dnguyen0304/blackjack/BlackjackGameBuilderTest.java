package com.github.dnguyen0304.blackjack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BlackjackGameBuilderTest {

    private BlackjackGameBuilder builder;
    private DealablePosition position;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.builder = new BlackjackGameBuilder();
    }

    @Test
    public void testBuild() {
        for (int i = 0; i < BlackjackGameBuilder.PLAYER_MINIMUM; i++) {
            this.builder.withPosition(position);
        }
        this.builder.build();
    }

    @Test
    public void testBuildTooFewPositions() {
        this.exception.expect(IllegalStateException.class);
        this.builder.build();
    }

    @Test
    public void testBuildTooManyPositions() {
        for (int i = 0; i < BlackjackGameBuilder.PLAYER_MAXIMUM + 1; i++) {
            this.builder.withPosition(position);
        }
        this.exception.expect(IllegalStateException.class);
        this.builder.build();
    }

}
