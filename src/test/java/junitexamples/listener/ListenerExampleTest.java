package junitexamples.listener;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by ONUR on 27.03.2016.
 */
@RunWith(MyTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListenerExampleTest {

    static WebDriver driver;
    final private static String URL = "http://www.swtestacademy.com";

    @BeforeClass
    public static void setupTest(){
        driver = new HtmlUnitDriver();
        driver.get(URL);
    }

    /*
    //If you want, you can add Retry Rule. (I explained it in another post.)
    //Thus, when your test fails, it will rerun by given retry count.
    @Rule
    public RetryRule retryRule = new RetryRule(3);
    */

    @Test
    public void T01_PassTest() {
        //Check title
        assertThat(driver.getTitle(), is("Software Test Academy"));
    }

    @Test
    public void T02_FailTest() {
        //Check title
        assertEquals("Title is wrong!!!", "WRONG TITLE", driver.getTitle());
    }

    //IntelliJ ignored by default
    @Ignore
    public void T03_IgnoreTest() {
        //Check title is correct
        assertThat(driver.getTitle(), is("Software Test Academy"));
    }

    //Throw Exception
    @Test
    public void T04_ExceptionTest() {
        throw new RuntimeException();
    }
}
