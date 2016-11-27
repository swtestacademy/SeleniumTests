package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

/**
 * Created by ONUR on 16.09.2015.
 */
public class RuleChainTest {

    @Rule
    public TestRule chain = RuleChain
            .outerRule(new LoggingRule("outer rule"))
            .around(new LoggingRule("middle rule"))
            .around(new LoggingRule("inner rule"));
    @Test
    public void test() {
    }
}
