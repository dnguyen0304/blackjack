package com.github.dnguyen0304.blackjack;

import java.io.BufferedReader;
import java.io.IOException;

public class BlackjackAsker {

    private BufferedReader reader;

    public BlackjackAsker(BufferedReader reader) {
        this.reader = reader;
    }

    public int askForBetAmount(Player player) throws IOException {
        String input = this.reader.readLine();
        int amount = Integer.parseInt(input);
        return amount;
    }

}
