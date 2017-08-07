package com.github.dnguyen0304.blackjack;

import java.util.HashMap;
import java.util.Map;

// This ValuedCard could implement the Card and Valuable interfaces.
public class BlackjackCard {

    // This is called a "static initialization block".
    private static final Map<Rank, Integer> ranksToValues;
    static {
        ranksToValues = new HashMap<Rank, Integer>();
        ranksToValues.put(Rank.ACE, 1);
        ranksToValues.put(Rank.TWO, 2);
        ranksToValues.put(Rank.THREE, 3);
        ranksToValues.put(Rank.FOUR, 4);
        ranksToValues.put(Rank.FIVE, 5);
        ranksToValues.put(Rank.SIX, 6);
        ranksToValues.put(Rank.SEVEN, 7);
        ranksToValues.put(Rank.EIGHT, 8);
        ranksToValues.put(Rank.NINE, 9);
        ranksToValues.put(Rank.TEN, 10);
        ranksToValues.put(Rank.JACK, 10);
        ranksToValues.put(Rank.QUEEN, 10);
        ranksToValues.put(Rank.KING, 10);
    }

    private final Rank rank;
    private final Suit suit;

    public BlackjackCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int value() {
        return BlackjackCard.ranksToValues.get(this.rank);
    }

}
