package com.github.dnguyen0304.blackjack;

public class ApplicationFactory {

    private final String[] args;

    public ApplicationFactory(String[] args) {
        this.args = args;
    }

    // How do you define a generic method signature for returning any object?
    public Application create() {
        Application application = new Application();
        return application;
    }

}
