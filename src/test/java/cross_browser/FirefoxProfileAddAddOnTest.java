package cross_browser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

public class FirefoxProfileAddAddOnTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() throws IOException {
        //XPI files are the addons installation files.
        //Set the firebug addon's XPI file location
        String firebugPath = "src\\main\\resources\\firebug-2.0.14.xpi";

        //Create a new Profile
        FirefoxProfile profile = new FirefoxProfile();

        //Send the XPI's path to the profile
        profile.addExtension(new File(firebugPath));

        //Set default Firebug preferences
        String ext = "extensions.firebug.";

        //Setting Preferences
        profile.setPreference(ext + "currentVersion", "2.0.14");
        profile.setPreference(ext + "allPagesActivation", "on");
        profile.setPreference(ext + "defaultPanelName", "net");
        profile.setPreference(ext + "net.enableSites", true);

        //Declare driver with profile
        driver = new FirefoxDriver(profile);
    }

    @Test
    public void prfoileTest() throws IOException {
        //Go to www.swtestacademy.com
        driver.get("http://www.swtestacademy.com");
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}

