package com.github.dnguyen0304.blackjack;

public class Main {

    public static void main(String[] args) throws Exception {
        Application application = new DefaultApplicationFactory(args).create();
        application.start();
    }

}
