package com.github.dnguyen0304.blackjack;

public class DefaultBlackjackGame implements BlackjackGame {

    private Game game;
    private Player dealer;

    public DefaultBlackjackGame(Game game) {
        this.game = game;
    }

    @Override
    public int getPlayerCount() {
        return this.game.getPlayerCount();
    }

    @Override
    public void setDealer(Player dealer) {
        this.addPlayer(dealer);
        this.dealer = dealer;
    }

    @Override
    public void addPlayer(Player player) throws IllegalStateException {
        this.game.addPlayer(player);
    }

}
