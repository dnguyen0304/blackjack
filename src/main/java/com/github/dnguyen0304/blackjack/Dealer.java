package com.github.dnguyen0304.blackjack;

import java.io.IOException;

public interface Dealer extends CardGamePlayer, Drawable {

    public void shuffle();

    public void askForBet(CardGamePlayer player) throws IOException;

}
