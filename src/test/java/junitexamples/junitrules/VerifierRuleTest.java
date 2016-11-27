package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ONUR BASKIRT on 13.09.2015.
 */
public class VerifierRuleTest {

    private List<String> errorLog = new ArrayList<String>();

    @Rule
    public Verifier verifier = new Verifier() {
        //After each method perform this check
        @Override public void verify() {
            assertTrue("Error Log is not Empty!",errorLog.isEmpty());
        }
    };

    @Test
    public void testWritesErrorLog() {
        //...
        errorLog.add("There is an error!");
    }
}
