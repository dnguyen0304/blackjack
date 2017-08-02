package com.github.dnguyen0304.blackjack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultBlackjackTableTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddDealerMultiple() {
        BlackjackTable table = new BlackjackTableBuilder()
            .withPosition(new DefaultPosition())
            .withPosition(new DefaultPosition())
            .build();
        Player dealer = new DefaultDealer(new DefaultPlayer(null));
        table.addDealer(dealer);
        this.exception.expect(IllegalStateException.class);
        table.addDealer(dealer);
    }

}
