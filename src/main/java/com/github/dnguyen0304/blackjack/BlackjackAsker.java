package com.github.dnguyen0304.blackjack;

import java.io.BufferedReader;
import java.io.IOException;

public class BlackjackAsker {

    private BufferedReader in;

    public BlackjackAsker(BufferedReader in) {
        this.in = in;
    }

    public int askForBetAmount(Player player) throws IOException {
        String input = this.in.readLine();
        int amount = Integer.parseInt(input);
        return amount;
    }

}
