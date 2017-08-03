package com.github.dnguyen0304.blackjack;

public class Application {

    private BlackjackGame game;

    public Application(BlackjackGame game) {
        this.game = game;
    }

    public void start() {
        this.game.play();
    }

}
