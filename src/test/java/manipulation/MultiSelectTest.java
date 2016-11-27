package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by ONUR on 12.11.2015.
 */
public class MultiSelectTest {

    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void MultiSelectTest() {
        //Navigate to w3schools.com
        driver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        driver.manage().window().maximize();

        //Switch to iframeResult iframe because all elements located in this iframe
        //It will be described in next topics
        driver.switchTo().frame("iframeResult");

        //Find multiple select and its options
        WebElement multiSelect = driver.findElement(By.cssSelector("select[name='cars']"));
        List<WebElement> multiSelectOptions = multiSelect.findElements(By.tagName("option"));

        //Find submit button
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        //Select Volvo (0) and Opel (2)
        multiSelectOptions.get(0).click();
        multiSelectOptions.get(2).click();

        //Click Submit Button
        submitButton.click();

        //Check the result
        WebElement resultSecondLine = driver.findElement(By.cssSelector("html>body>h3:nth-of-type(2)"));
        System.out.println("ResultText: "+resultSecondLine.getText());
        assertTrue("volvo is not selected!", resultSecondLine.getText().contains("volvo"));
        assertTrue("opel is not selected!", resultSecondLine.getText().contains("opel"));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
