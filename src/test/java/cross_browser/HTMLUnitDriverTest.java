package cross_browser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;

public class HTMLUnitDriverTest {
    static WebDriver driver;

    @Test
    public void HTMLUnitDriverTest() {
        //Declare HTMLUnitDriver
        driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);

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
