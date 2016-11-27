package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ONUR on 18.11.2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActionsTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        //Enabling actual mouse clicks (Not javascript triggering) --Generally make this ON
        //FirefoxProfile profile = new FirefoxProfile();
        //profile.setEnableNativeEvents(true);
        /*String geckoDriverLocation = System.getProperty("user.dir") + "\\tools\\drivers\\firefox\\geckodriver.exe";
        System.out.println("Gecko Driver: " + geckoDriverLocation );
        System.setProperty("webdriver.gecko.driver", geckoDriverLocation);*/
        //driver = new FirefoxDriver();

        //FIREFOX
        String geckoDriverLocation = System.getProperty("user.dir") + "\\tools\\drivers\\firefox\\geckodriver.exe";
        System.out.println("Gecko Driver: " + geckoDriverLocation );
        System.setProperty("webdriver.firefox.driver", geckoDriverLocation);
        driver = new FirefoxDriver();


        //CHROME
        /*String chromeDriverLocation = System.getProperty("user.dir") + "\\tools\\drivers\\chrome\\chromedriver.exe";
        System.out.println("Chrome Driver: " + chromeDriverLocation );
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();*/
    }

    @Test
    public void T01_BasicActionsTest() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Login Button
        WebElement loginButton = driver.findElement(By.id("loginbutton"));

        //Actions example
        Action clickToLoginButton = new Actions(driver).click(loginButton).build();

        clickToLoginButton.perform();

    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        //driver.quit();
    }
}
