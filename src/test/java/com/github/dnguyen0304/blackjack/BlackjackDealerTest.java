package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class BlackjackDealerTest {

    private Dealer dealer;
    private CardGamePlayer other;

    @Before
    public void setUp() {
        CardGamePlayer player = new BlackjackPlayer(null, 0);

        Reader reader = new StringReader(String.valueOf(1));
        BufferedReader in = new BufferedReader(reader);
        BlackjackAsker asker = new BlackjackAsker(in);

        this.dealer = new BlackjackDealer(player, null, null, asker);
        this.other = new BlackjackPlayer(null, 0);
    }

    @Test
    public void testAskForBetFromDealer() throws IOException {
        int originalChipTotal = this.dealer.getChipTotal();
        this.dealer.askForBet(this.dealer);
        assertEquals(originalChipTotal, this.dealer.getChipTotal());
    }

    @Test
    public void testAskForBetFromNonDealer() throws IOException {
        int originalChipTotal = this.other.getChipTotal();
        this.dealer.askForBet(this.other);
        assertNotEquals(originalChipTotal, this.other.getChipTotal());
    }

}
