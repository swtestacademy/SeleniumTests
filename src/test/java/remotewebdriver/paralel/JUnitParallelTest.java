package remotewebdriver.paralel;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

@RunWith(Parallelized.class)
public class JUnitParallelTest {
    //Declare DesiredCapabilities configuration variables
    private String platform; //Use if you need to use platform
    //private String os;
    //private String osVersion;
    private String browserName;
    //private String browserVersion;

    //Hold all Configuration values in a LinkedList
    @Parameterized.Parameters
    public static LinkedList<String[]> getEnvironments() throws Exception {
        LinkedList<String[]> env = new LinkedList<String[]>();
        env.add(new String[]{"chrome"});
        env.add(new String[]{"firefox"});
        env.add(new String[]{"IE"});
        env.add(new String[]{"Edge"});
        //add more browsers here
        return env;
    }

    //Constructor
    public JUnitParallelTest(String browserName) {

        this.browserName = browserName;

    }

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //Set DesiredCapabilities
        DesiredCapabilities capability = new DesiredCapabilities();
        //capability.setCapability("platform", platform);


        capability.setCapability("browser", browserName);

        capability.setCapability("build", "JUnit-Parallel");
        //Connect to BrowserStack with your credentials
        driver = new RemoteWebDriver(
                new URL("http://onur52:8x8xWLowM7Vs7fnejHSR@hub.browserstack.com/wd/hub"),
                capability
        );
    }

    @Test
    public void testSimple() throws Exception {
        //Go to swtestacademy and check title
        driver.get("http://www.swtestacademy.com");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        assertEquals("Title is not correct!", "Software Test Academy", driver.getTitle());

        //ScreenShot Section
        driver = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("Screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}