package cross_browser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDesiredCapabilitiesProxyTest {
    static WebDriver driver;
    private static String url = "http://www.swtestacademy.com";
    public static String PROXY = "localhost:8080";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY)
                .setFtpProxy(PROXY)
                .setSslProxy(PROXY);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        driver = new FirefoxDriver(capabilities);
    }

    @Test
    public void proxyTest() {
        //Go to www.swtestacademy.com
        driver.get(url);
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
