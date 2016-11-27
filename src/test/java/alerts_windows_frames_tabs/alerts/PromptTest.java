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

public class PromptTest {
    static WebDriver driver;
    private static String url = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";

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
    public void PromptExampleTest() {
        //Switch to iframeResult iframe because all elements located in this iframe
        //It will be described in next topics
        driver.switchTo().frame("iframeResult");

        //Find "Try it" button
        WebElement promptButton = driver.findElement(By.cssSelector("html>body>button"));

        //Actual Message
        WebElement actualPromptMessage = driver.findElement(By.cssSelector("#demo"));

        //Click confirm button ("Try it" button)
        promptButton.click();

        //Send "SW Test Academy" to Alert's text box
        driver.switchTo().alert().sendKeys("SW Test Academy");

        //Accept the alert (Click Ok button)
        driver.switchTo().alert().accept();

        //Assertion
        assertThat("Hello SW Test Academy! How are you today?",is(actualPromptMessage.getText()));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
