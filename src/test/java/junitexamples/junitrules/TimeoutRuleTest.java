package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by ONUR on 12.09.2015.
 */
public class TimeoutRuleTest {
    @Rule
    public Timeout timeout = new Timeout(2000);

    @Test
    public void testA() throws Exception {
        // Open a website...
    }

    @Test
    public void testB() throws Exception {
        // Login a website etc.
    }
}
