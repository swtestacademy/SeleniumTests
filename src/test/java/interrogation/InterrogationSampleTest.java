package interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ONUR on 11.10.2015.
 */
public class InterrogationSampleTest {
    static WebDriver driver;
    final static private String URL = "http://www.google.com";

    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to(URL);
    }

    //Sample Interrogation Example
    @Test
    public void getTextofAnElement() {
        //1) Find the element that we will interrogate
        WebElement gmailLink = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div/div/div[1]/div[1]/a"));

        //2) Interrogate search button text
        assertThat(gmailLink.getText(), is("Gmail"));
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
