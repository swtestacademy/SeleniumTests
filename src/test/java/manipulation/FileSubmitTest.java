package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.URISyntaxException;

import static org.junit.Assert.assertTrue;

/**
 * Created by ONUR on 12.11.2015.
 */
public class FileSubmitTest {

    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void SubmitFileTest() throws URISyntaxException {
        //Navigate to http://www.w3schools.com/
        driver.navigate().to("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        driver.manage().window().maximize();

        //Switch to iframeResult iframe because all elements located in this iframe
        driver.switchTo().frame("iframeResult");

        //Find the elements
        WebElement browseButton = driver.findElement(By.cssSelector("input[name=img]"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type=submit]"));

        //Test file decleration
        File testFile = new File(this.getClass().getResource("/test_file.txt").toURI());

        //Select test file operation
        browseButton.sendKeys(testFile.getAbsolutePath());

        //Click submit button
        submitButton.click();

        //Check the result
        WebElement resultText = driver.findElement(By.cssSelector("html>body>h3:nth-of-type(2)"));
        System.out.println("resulttext: " + resultText.getText());
        assertTrue("test_file.txt is not submitted!", resultText.getText().contains("test_file"));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
