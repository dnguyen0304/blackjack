package com.github.dnguyen0304.blackjack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BlackjackTableBuilderTest {

    private BlackjackTableBuilder builder;
    private Position position;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.builder = new BlackjackTableBuilder();
    }

    @Test
    public void testBuild() {
        for (int i = 0; i < BlackjackTableBuilder.PLAYER_MINIMUM; i++) {
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
        for (int i = 0; i < BlackjackTableBuilder.PLAYER_MAXIMUM + 1; i++) {
            this.builder.withPosition(position);
        }
        this.exception.expect(IllegalStateException.class);
        this.builder.build();
    }

}
