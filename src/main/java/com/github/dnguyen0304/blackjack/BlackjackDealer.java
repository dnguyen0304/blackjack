package com.github.dnguyen0304.blackjack;

public class BlackjackDealer implements Player, Drawable {

    private Player player;
    private Drawable deck;

    public BlackjackDealer(Player player, Drawable deck) {
        this.player = player;
        this.deck = deck;
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
    public BlackjackCard draw() {
        return this.deck.draw();
    }

}
