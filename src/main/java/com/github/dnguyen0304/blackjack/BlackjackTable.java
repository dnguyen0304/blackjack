package com.github.dnguyen0304.blackjack;

public interface BlackjackTable extends Table {

    public void addDealer(Player dealer) throws IllegalStateException;

}
