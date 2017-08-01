package com.github.dnguyen0304.blackjack;

// What are the best practices regarding inheriting interfaces?
public interface Deck extends Iterable<Card> {

	public int getCount();

	public void add(Card card);

	public Card draw();

	public void merge(Iterable<Card> other);

}
