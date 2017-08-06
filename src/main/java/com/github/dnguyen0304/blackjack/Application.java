package com.github.dnguyen0304.blackjack;

import java.io.IOException;

public class Application {

    private BlackjackGame game;

    public Application(BlackjackGame game) {
        this.game = game;
    }

    public void start() throws IOException {
        this.game.play();
    }

}
