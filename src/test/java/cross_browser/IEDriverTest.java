package cross_browser;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by Onur on 17.02.2016.
 */
public class IEDriverTest {
    static WebDriver driver;

    //Setup IEDriver
    @BeforeClass
    public static void setupTest()   {
        //Declare IEDriver Path
        String currentDir = System.getProperty("user.dir");
        System.out.print("current dir: " + currentDir + "\n");
        String IEDriverLocation = currentDir + "\\src\\tools\\IEDriverServer.exe";
        System.out.print("IE directory: " + IEDriverLocation + "\n");
        System.setProperty("webdriver.ie.driver", IEDriverLocation);
    }

    @Test
    public void basicIEDriverTest() throws InterruptedException {
        //DesiredCapabilities (You can set IE version with below desired capabilities lines.)
        /*DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
        capability.setCapability(CapabilityType.VERSION, "8");
        capability.setCapability(CapabilityType.PLATFORM, "WINDOWS");*/


        //Declare IEDriver
        //driver = new InternetExplorerDriver(capability);  //Use it when enable DesiredCapabilities
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();

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
