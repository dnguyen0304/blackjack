package com.github.dnguyen0304.blackjack;

// TODO Change this into an abstract factory.
public class DefaultPositionFactory {

    public DefaultPosition create() {
        BlackjackHand hand = new BlackjackHand();
        DefaultPosition position = new DefaultPosition(hand);
        return position;
    }

}
