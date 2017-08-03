package com.github.dnguyen0304.blackjack;

public class DefaultBlackjackGame implements BlackjackTable {

    private Table table;
    private Player dealer;

    public DefaultBlackjackGame(Table table) {
        this.table = table;
    }

    @Override
    public int getPlayerCount() {
        return this.table.getPlayerCount();
    }

    @Override
    public void setDealer(Player dealer) {
        this.addPlayer(dealer);
        this.dealer = dealer;
    }

    @Override
    public void addPlayer(Player player) throws IllegalStateException {
        this.table.addPlayer(player);
    }

}
