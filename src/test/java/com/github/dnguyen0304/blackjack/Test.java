package com.github.dnguyen0304.blackjack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlackjackGameBuilderTest.class,
                BlackjackGameTest.class,
                BlackjackHandTest.class,
                DealablePositionTest.class,
                DeckTest.class })
public class Test {

}
