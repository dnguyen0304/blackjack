package com.github.dnguyen0304.blackjack;

public class BlackjackDealer implements Dealer {

    private CardGamePlayer player;
    private Drawable deck;
    private CardShuffler cardShuffler;

    public BlackjackDealer(CardGamePlayer player, Drawable deck, CardShuffler cardShuffler) {
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
    public void bet(int amount) {
        this.player.bet(amount);
    }

    @Override
    public void shuffle() {
        this.deck = this.cardShuffler.shuffle(this.deck);
    }

    @Override
    public BlackjackCard draw() {
        return this.deck.draw();
    }

    @Override
    public BlackjackHand getHand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addToHand(BlackjackCard card) {
        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(CardGamePlayer o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
