package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

/**
 * Created by ONUR BASKIRT on 14.09.2015.
 */
public class NameRuleTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void testOne() {
        assertEquals("testOne", name.getMethodName());
    }

    @Test
    public void testTwo() {
        assertEquals("testTwo", name.getMethodName());
    }
}
