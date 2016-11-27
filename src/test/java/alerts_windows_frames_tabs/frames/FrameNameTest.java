package alerts_windows_frames_tabs.frames;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FrameNameTest {

    static WebDriver driver;
    private String url = "http://www.londonfreelance.org/courses/frames/index.html";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void FrameExampleTest() {
        //Navigate to URL
        driver.manage().window().maximize();
        driver.navigate().to(url);

        //Switch to main frame with its name (top.html)
        //This frame's name is main
        driver.switchTo().frame("main");

        //Check the H2 tag's text is "Title bar (top.html)
        WebElement h2Tag = driver.findElement(By.cssSelector("html>body>h2"));
        assertThat("Title bar (top.html)", is(h2Tag.getText()));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
