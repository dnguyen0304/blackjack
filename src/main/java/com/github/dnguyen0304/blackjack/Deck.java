package com.github.dnguyen0304.blackjack;

public interface Deck {

    public int getCount();

    public void add(Card card);

    public void addToBottom(Card card);

    public Card draw();

    public Card drawFromBottom();

    public void stackOnto(Deck other);

}
