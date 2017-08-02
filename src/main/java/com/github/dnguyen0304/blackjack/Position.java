package com.github.dnguyen0304.blackjack;

public interface Position {

    public Boolean isOpen();

    public Player getPlayer();

    public void setPlayer(Player player);

    public int getBet();

    public void setBet(int bet);

}
