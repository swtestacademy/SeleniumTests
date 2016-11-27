package interrogation;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by ONUR on 10.10.2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverLevelInterrogationTest {
    static WebDriver driver;
    final private String URL = "http://www.teknosa.com";

    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Before
    public void navigateToWebPage () {
        //Go to www.teknosa.com
        driver.navigate().to(URL);
    }

    //.getTitle Example
    @Test
    public void T01_getTitle() {
        //Check title
        assertThat(driver.getTitle(), is("Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji"));
    }

    //.getCurrentURL Example
    @Test
    public void T02_getCurrentURL() {
        //Check Current URL
        assertThat(driver.getCurrentUrl(), is("http://www.teknosa.com/"));
    }

    //.getPageSource Example
    @Test
    public void T03_getPageSource() {
        //Get PageSource and save it into a String
        String pageSource = driver.getPageSource();

        //Check page source contains "Teknosa"
        assertTrue((pageSource.contains("Teknosa")));
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
