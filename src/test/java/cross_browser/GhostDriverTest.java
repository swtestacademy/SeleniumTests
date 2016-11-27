package cross_browser;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by Onur on 10.02.2016.
 */
public class GhostDriverTest {
    //Declare PhantomJS path
    public static final File PhantomJS_EXE = new File(System.getProperty("user.dir"), "src/tools/phantomjs-2.1.1-windows/bin/phantomjs.exe");
    //String currentDir = System.getProperty("user.dir");
    //String phantomJSLocation = currentDir + "\\src\\tools\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
    static WebDriver driver;

    @Test
    public void GhostDriverTest() {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("phantomjs.binary.path", PhantomJS_EXE.getAbsolutePath());

        //Declare PhantomJS Driver
        driver = new PhantomJSDriver(caps);

        //Go to swtestacademy and check title
        driver.get("http://www.swtestacademy.com");
        assertEquals("Title is not correct!","Software Test Academy", driver.getTitle());
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
