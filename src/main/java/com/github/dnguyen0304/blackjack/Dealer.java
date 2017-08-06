package com.github.dnguyen0304.blackjack;

public interface Dealer extends CardGamePlayer, Drawable {

    public void shuffle();

    public void askForBet(CardGamePlayer player);

}
