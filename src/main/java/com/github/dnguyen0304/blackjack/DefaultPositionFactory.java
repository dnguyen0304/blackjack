package com.github.dnguyen0304.blackjack;

// TODO Change this into an abstract factory.
public class DefaultPositionFactory {

    public DealablePosition create() {
        BlackjackHand hand = new BlackjackHand();
        DealablePosition position = new DealablePosition(hand);
        return position;
    }

}
