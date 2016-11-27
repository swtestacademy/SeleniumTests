package cross_browser;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

/**
 * Created by Onur on 11.02.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChromeDriverTest {
    static WebDriver driver;

    //Setup ChromeDriver
    @BeforeClass
    public static void setupTest()   {
        //Declare ChromeDriver Path
        String currentDir = System.getProperty("user.dir");
        System.out.print("current dir: " + currentDir);
        String chromeDriverLocation = currentDir + "\\src\\tools\\chromedriver.exe";
        System.out.print("chrome dir: " + chromeDriverLocation);
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
    }

    @Test
    public void T01_basicChromeDriverTest()   {
        //Declare ChromeDriver
        driver = new ChromeDriver();

        //Go to www.swtestacademy.com
        driver.get("http://www.swtestacademy.com");
        assertEquals("Title is not correct!","Software Test Academy", driver.getTitle());
    }

    @Test
    public void T02_optionsChromeDriverTest() {
        //Define Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");

        //Declare Chrome driver with options
       driver = new ChromeDriver(options);

        //Go to www.swtestacademy.com
        driver.get("http://www.swtestacademy.com");
        assertEquals("Title is not correct!", "Software Test Academy", driver.getTitle());
    }

    //Close Driver
    @After
    public void quitDriver() {
        driver.quit();
    }
}
