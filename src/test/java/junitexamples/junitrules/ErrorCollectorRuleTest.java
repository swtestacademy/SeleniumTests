package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created by ONUR on 13.09.2015.
 */
public class ErrorCollectorRuleTest {

    @Rule
    public ErrorCollector collector= new ErrorCollector();

    @Test
    public void example() {
        collector.addError(new Throwable("First Error!"));
        collector.addError(new Throwable("Second Error!"));

        collector.checkThat(5, is(8)); //First Error
        collector.checkThat(5, is(not(8))); //Passed
        collector.checkThat(5, is(equalTo(9))); //Second Error
    }
}
