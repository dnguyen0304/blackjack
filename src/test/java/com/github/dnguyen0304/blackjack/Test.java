package com.github.dnguyen0304.blackjack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DefaultBlackjackTableBuilderTest.class,
                DefaultBlackjackTableTest.class,
                DefaultDeckTest.class,
                DefaultTableTest.class,
                StackOntoDeckShuffleStrategyTest.class })
public class Test {

}
