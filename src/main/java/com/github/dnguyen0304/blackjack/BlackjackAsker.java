package com.github.dnguyen0304.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

public class BlackjackAsker {

    private BufferedReader in;
    private Writer out;

    public BlackjackAsker(BufferedReader in, Writer out) {
        this.in = in;
        this.out = out;
    }

    public int askForBetAmount(Player player) throws IOException {
        String message = "Enter your bet amount: ";

        out.write(message);
        out.flush();

        String input = this.in.readLine();
        int amount = Integer.parseInt(input);

        return amount;
    }

}
