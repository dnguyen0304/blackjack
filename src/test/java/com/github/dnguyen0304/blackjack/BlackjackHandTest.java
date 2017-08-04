package com.github.dnguyen0304.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlackjackHandTest {

    private BlackjackHand hand;
    private BlackjackHand other;

    @Before
    public void setUp() {
        this.hand = new BlackjackHand();
        this.other = new BlackjackHand();
    }

    @Test
    public void testAddHardNoAces() {
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        assertEquals(4, this.hand.value());
    }

    @Test
    public void testAddHardSingleAce() {
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        this.hand.add(new BlackjackCard(Rank.NINE, null));
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        assertEquals(12, this.hand.value());
    }

    @Test
    public void testAddHardMultipleAces() {
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        this.hand.add(new BlackjackCard(Rank.NINE, null));
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        assertEquals(13, this.hand.value());
    }

    @Test
    public void testAddSoftSingleAce() {
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        assertEquals(13, this.hand.value());
    }

    @Test
    public void testAddSoftMultipleAces() {
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        assertEquals(12, this.hand.value());
    }

    @Test
    public void testAddBust() {
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        assertEquals(-1, this.hand.value());
    }

    @Test
    public void testCompareToLessThan() {
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        this.other.add(new BlackjackCard(Rank.THREE, null));
        int result = this.hand.compareTo(other);
        assertEquals(result, Comparison.LESS_THAN.getValue());
    }

    @Test
    public void testCompareToEqualTo() {
        this.hand.add(new BlackjackCard(Rank.ACE, null));
        this.other.add(new BlackjackCard(Rank.ACE, null));
        int result = this.hand.compareTo(other);
        assertEquals(result, Comparison.EQUAL_TO.getValue());
    }

    @Test
    public void testCompareToGreaterThan() {
        this.hand.add(new BlackjackCard(Rank.THREE, null));
        this.other.add(new BlackjackCard(Rank.TWO, null));
        int result = this.hand.compareTo(other);
        assertEquals(result, Comparison.GREATER_THAN.getValue());
    }

    @Test
    public void testCompareToBustLessThan() {
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.other.add(new BlackjackCard(Rank.TWO, null));
        int result = this.hand.compareTo(other);
        assertEquals(result, Comparison.LESS_THAN.getValue());
    }

    @Test
    public void testCompareToBustEqualTo() {
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.hand.add(new BlackjackCard(Rank.TEN, null));
        this.other.add(new BlackjackCard(Rank.TEN, null));
        this.other.add(new BlackjackCard(Rank.TEN, null));
        this.other.add(new BlackjackCard(Rank.TEN, null));
        int result = this.hand.compareTo(other);
        assertEquals(result, Comparison.EQUAL_TO.getValue());
    }

    @Test
    public void testCompareToBustGreaterThan() {
        this.hand.add(new BlackjackCard(Rank.TWO, null));
        this.other.add(new BlackjackCard(Rank.TEN, null));
        this.other.add(new BlackjackCard(Rank.TEN, null));
        this.other.add(new BlackjackCard(Rank.TEN, null));
        int result = this.hand.compareTo(other);
        assertEquals(result, Comparison.GREATER_THAN.getValue());
    }

}
