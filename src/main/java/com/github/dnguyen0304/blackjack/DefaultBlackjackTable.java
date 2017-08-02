package com.github.dnguyen0304.blackjack;

public class DefaultBlackjackTable implements BlackjackTable {

    private Table table;
    private Player dealer;

    public DefaultBlackjackTable(Table table) {
        this.table = table;
    }

    public void addDealer(Player dealer) throws IllegalStateException {
        if (this.dealer != null) {
            String message = "There is already a dealer at this table.";
            throw new IllegalStateException(message);
        }
        this.addPlayer(dealer);
        this.dealer = dealer;
    }

    @Override
    public void addPlayer(Player player) throws IllegalStateException {
        this.table.addPlayer(player);
    }

}
