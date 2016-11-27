package remotewebdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SauceLabsTest {
    static WebDriver driver;
    public static final String USERNAME = "swtestacademy";
    public static final String ACCESS_KEY = "90da4ae1-7f62-4a60-880e-945aa2ef13f0";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    @BeforeClass
    public static void setupTest() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", Platform.MAC);
        caps.setCapability("version", "44");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public void SauceLabsTest() {
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

