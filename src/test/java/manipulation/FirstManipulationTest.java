package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ONUR on 26.10.2015.
 */
public class FirstManipulationTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    //Find First name text box with CSS Selector
    @Test
    public void T01_firstManipulationTest() throws InterruptedException {
        //Navigate to http://www.turkishairlines.com/en-int/
        driver.navigate().to("http://www.turkishairlines.com/en-int/");

        //Find first magnifier
        WebElement firstMagnifier = driver.findElement(By.cssSelector(".left>.form-item>.search.float-left"));

        //Click first magnifier
        firstMagnifier.click();

        //Thread Sleep
        Thread.sleep(1000);

        //Switch to
        //"Main-Quick-Search-Ticket
        /*WebElement form = driver.findElement(By.id("Main-Quick-Search-Ticket"));
        driver.switchTo().frame(form);*/


        //Select From City as Istanbul Ataturk Airport
        //WebElement fromCity = driver.findElement(By.cssSelector("#ctlCity>option[value='IST,IST']"));
        //.//*[@id='ctlCity']/option[26] Xpath
        ////*[@class='current-month weekend'][text()="31"]

        //Click from city
        //fromCity.click();

        //ctlCity
        new Select(driver.findElement(By.id("ctlCity"))).selectByVisibleText("Istanbul Ataturk Airport");
        driver.findElement(By.cssSelector("option[value=\"IST,IST\"]")).click();
        //driver.findElement(By.cssSelector("option[value='IST,IST']")).click();

        Thread.sleep(3000);




        //Select the From City

        //Click the to magnifier

        //Select the To City

        //Click the Flight Search Button

        //Check the title

        //Assert that text box is empty
        //assertThat(firstNameTextBox.getText(), is(""));

        //id="mainBody"
        /*WebElement body = driver.findElement(By.id("mainBody"));
        driver.switchTo().frame(body);*/
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
