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

public class ConfirmTest {
    static WebDriver driver;
    private static String url = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        //Navigate to URL
        driver.navigate().to(url);
        //Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void ConfirmExampleTest() {
        //Switch to iframeResult iframe because all elements located in this iframe
        //It will be described in next topics
        driver.switchTo().frame("iframeResult");

        //Find "Try it" button
        WebElement confirmButton = driver.findElement(By.cssSelector("html>body>button"));

        //Actual Text Element
        WebElement actualConfirmMessage = driver.findElement(By.cssSelector("#demo"));

        //******************************
        // Accept Test (Test Scenario-1)
        //******************************

        //Click confirm button ("Try it" button)
        confirmButton.click();

        //Accept the alert (Click Ok button)
        driver.switchTo().alert().accept();

        //Assertion
        assertThat("You pressed OK!",is(actualConfirmMessage.getText()));

        //******************************
        // Dismiss Test (Test Scenario-2)
        //******************************

        //Click confirm button ("Try it" button)
        confirmButton.click();

        //Accept the alert (Click Cancel)
        driver.switchTo().alert().dismiss();

        //Assertion
        assertThat("You pressed Cancel!",is(actualConfirmMessage.getText()));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
