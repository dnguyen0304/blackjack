package com.github.dnguyen0304.blackjack;

public class BlackjackDealer implements Dealer {

    private Player player;
    private Drawable deck;
    private CardShuffler cardShuffler;

    public BlackjackDealer(Player player, Drawable deck, CardShuffler cardShuffler) {
        this.player = player;
        this.deck = deck;
        this.cardShuffler = cardShuffler;
    }

    @Override
    public String getName() {
        return this.player.getName();
    }

    @Override
    public int getChipTotal() {
        return this.player.getChipTotal();
    }

    @Override
    public void setChipTotal(int chipTotal) {
        this.player.setChipTotal(chipTotal);
    }

    @Override
    public void shuffle() {
        this.deck = this.cardShuffler.shuffle(this.deck);
    }

    @Override
    public BlackjackCard draw() {
        return this.deck.draw();
    }

}
