package Examples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class aol {
    static WebDriver driver;
    private static String url = "http://search.aol.com/aol/search?enabled_terms=&s_it=comsearch&q=aol+autos&s_qt=ac&s_chn=prt_main5&s_qt=ac&s_chn=prt_main5";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void aolTest() {
        //Declare Wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Sync for Web
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tab.atab.ftab")));

        //Check Web
        assertThat(driver.findElement(By.cssSelector(".tab.atab.ftab")).getText().trim(),is("Web"));

        //Wait and Click Autoblog
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".find[href='http://www.autoblog.com/']"))).click();
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
