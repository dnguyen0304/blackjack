package com.github.dnguyen0304.blackjack;

import java.io.IOException;

public class CommandLineApplication {

    private BlackjackGame game;

    public CommandLineApplication(BlackjackGame game) {
        this.game = game;
    }

    public void start() throws IOException {
        this.game.play();
    }

}
