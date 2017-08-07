package com.github.dnguyen0304.blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BlackjackGame {

    private Dealer dealer;
    private CardGamePlayer firstPlayer;
    private List<CardGamePlayer> otherPlayers;

    public BlackjackGame(Dealer dealer,
                         CardGamePlayer firstPlayer,
                         List<CardGamePlayer> otherPlayers) {
        this.dealer = dealer;
        this.firstPlayer = firstPlayer;
        this.otherPlayers = otherPlayers;
    }

    public int countPlayers() {
        return BlackjackGameBuilder.PLAYER_MINIMUM + this.otherPlayers.size();
    }

    public void play() throws IOException {
        Iterator<CardGamePlayer> players;

        System.out.println("The game is starting.");

        System.out.println("The dealer is shuffling the cards.");
        this.dealer.shuffle();

        players = this.createAllPlayerIterator();
        while (players.hasNext()) {
            CardGamePlayer player = players.next();
            System.out.println(String.format("It is %s's turn.", player.getName()));
            this.dealer.askForBet(player);
        }

        // TODO Deal the cards.
        // TODO Dispose the resources.
    }

    private Iterator<CardGamePlayer> createAllPlayerIterator() {
        List<CardGamePlayer> players = new ArrayList<CardGamePlayer>();
        players.add(this.firstPlayer);
        players.addAll(this.otherPlayers);
        players.add(this.dealer);
        Iterator<CardGamePlayer> playerIterator = new PlayerIterator(players);
        return playerIterator;
    }

    // How do closures behave?
    private class PlayerIterator implements Iterator<CardGamePlayer> {

        private List<CardGamePlayer> players;
        private int i = 0;

        public PlayerIterator(List<CardGamePlayer> players) {
            this.players = players;
        }

        @Override
        public boolean hasNext() {
            return i < this.players.size();
        }

        @Override
        public CardGamePlayer next() throws NoSuchElementException {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            CardGamePlayer player = this.players.get(this.i);
            this.i++;
            return player;
        }

    }

}
