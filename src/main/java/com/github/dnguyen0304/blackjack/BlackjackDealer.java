package com.github.dnguyen0304.blackjack;

import java.io.IOException;

public class BlackjackDealer implements Dealer {

    private CardGamePlayer player;
    private Drawable deck;
    private CardShuffler cardShuffler;
    private BlackjackAsker asker;

    public BlackjackDealer(CardGamePlayer player, Drawable deck, CardShuffler cardShuffler, BlackjackAsker asker) {
        this.player = player;
        this.deck = deck;
        this.cardShuffler = cardShuffler;
        this.asker = asker;
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
    public void askForBet(CardGamePlayer player) throws IOException {
        int amount = 0;
        if (this != player) {
            amount = this.asker.askForBetAmount(player);
        }
        player.bet(amount);
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
