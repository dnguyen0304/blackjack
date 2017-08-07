package com.github.dnguyen0304.blackjack;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CommandLineApplication application = new CommandLineApplicationFactory(args).create();
        application.start();
    }

}
