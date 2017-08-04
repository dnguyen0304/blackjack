package com.github.dnguyen0304.blackjack;

import java.util.ArrayList;
import java.util.List;

// This ValuedHand could implement the Hand and Valuable interfaces.
public class BlackjackHand implements Comparable<BlackjackHand> {

    private static final int VALUE_MAXIMUM = 21;

    private List<BlackjackCard> cards;
    private int value;
    private Boolean hasAce;

    /**
     * This constructor must be called by all other alternate or overloaded
     * constructors.
     *
     * @param cards List of cards contained in the hand.
     */
    public BlackjackHand(List<BlackjackCard> cards) {
        this.cards = cards;
        this.value = 0;
        this.hasAce = false;
    }

    public BlackjackHand() {
        this(new ArrayList<BlackjackCard>());
    }

    public void add(BlackjackCard card) {
        this.cards.add(card);
        if (!this.hasAce && card.getRank() == Rank.ACE) {
            this.hasAce = true;
        }
        this.updateValue(card);
    }

    private void updateValue(BlackjackCard card) {
        int result = this.value + card.value();
        if (card.getRank() == Rank.ACE) {
            result += 10;
            if (result > BlackjackHand.VALUE_MAXIMUM) {
                result -= 10;
            }
        }
        this.value = result;
    }

    /**
     * Calculate the value of the hand.
     *
     * @return Value of the hand if it is does not exceed the game's maximum
     *         and -1 otherwise ("bust").
     */
    public int value() {
        return (this.value <= BlackjackHand.VALUE_MAXIMUM) ? this.value : -1;
    }

    @Override
    public int compareTo(BlackjackHand other) {
        Comparison result = null;

        if (this.value() < other.value()) {
            result = Comparison.LESS_THAN;
        } else if (this.value() == other.value()) {
            result = Comparison.EQUAL_TO;
        } else if (this.value() > other.value()) {
            result = Comparison.GREATER_THAN;
        }

        return result.getValue();
    }

}
