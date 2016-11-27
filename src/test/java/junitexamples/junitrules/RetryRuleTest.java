package junitexamples.junitrules;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ONUR BASKIRT on 27.03.2016.
 */
public class RetryRuleTest {

    static WebDriver driver;
    final private String URL = "http://www.swtestacademy.com";

    @BeforeClass
    public static void setupTest(){
        driver = new FirefoxDriver();
    }

    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Test
    public void getURLExample() {
        //Go to www.swtestacademy.com
        driver.get(URL);

        //Check title is correct
        assertThat(driver.getTitle(), is("WRONG TITLE"));
    }
}
