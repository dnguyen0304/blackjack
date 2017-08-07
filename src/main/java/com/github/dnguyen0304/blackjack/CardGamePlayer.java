package com.github.dnguyen0304.blackjack;

public interface CardGamePlayer extends Player, Comparable<CardGamePlayer> {

    public BlackjackHand getHand();

    public void addToHand(BlackjackCard card);

}
