package remotewebdriver;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestingBot {

    static WebDriver driver;
    public static final String KEY = "b7f75263f8ed55037afa667c78e17f05";
    public static final String SECRET = "9ac5a89954e402d06eb07b69c9179a64";
    public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

    @BeforeClass
    public static void setupTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "WIN10");
        caps.setCapability("version", "11");
        caps.setCapability("browserName", "internet explorer");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public void TestingBotTest() {
        //Go to www.swtestacademy.com
        driver.get("http://www.swtestacademy.com/");

        //Check title is correct
        assertEquals("Title is not correct!", "Software Test Academy", driver.getTitle());
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
