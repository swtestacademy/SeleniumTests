package alerts_windows_frames_tabs.alerts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Onur on 15.12.2015.
 */
public class AlertExampleTest {
    static WebDriver driver;
    private String url = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void AlertExampleTest() {
        //Navigate to URL
        driver.navigate().to(url);
        driver.manage().window().maximize();

        //Switch to iframeResult iframe because all elements located in this iframe
        //It will be described in next topics
        driver.switchTo().frame("iframeResult");

        //Find "Try it" button
        WebElement alertButton = driver.findElement(By.cssSelector("html>body>button"));

        //Click alert button ("Try it" button)
        alertButton.click();

        //Alert Message (Expected Text)
        String expectedAlertMessage = "I am an alert box!";

        //Captured Alert Text (Actual Text)
        String actualAlertMessage = driver.switchTo().alert().getText();

        //Assertion
        assertThat(expectedAlertMessage,is(actualAlertMessage));

        //Accept the alert (Click OK)
        driver.switchTo().alert().accept();
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
