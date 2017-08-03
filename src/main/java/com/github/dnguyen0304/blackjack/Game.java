package com.github.dnguyen0304.blackjack;

public interface Game {

    public int getPlayerCount();

    public void addPlayer(Player player) throws IllegalStateException;

}
