package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ONUR on 17.09.2015.
 */
public class ScreenshotRuleTest {

    static WebDriver driver = new FirefoxDriver();

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule();

    @Test
    public void testScreenShot() {
        driver.get("http://www.teknosa.com");
        driver.findElement(By.id("asdasda"));
    }
}
