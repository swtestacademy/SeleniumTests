package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ONUR on 01.11.2015.
 */
public class SubmitFormTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void T01_submitWithForm() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find Form
        WebElement joinForm = driver.findElement(By.cssSelector(".join-linkedin-form.float-label-form"));

        //Submit Form
        joinForm.submit();

        //Assertion
        WebElement alert = driver.findElement(By.cssSelector(".uno-alert.error.hidden>p>strong"));
        assertThat(alert.getText(), is("Please enter your first name"));
    }

    @Test
    public void T02_submitWithButton() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find Form Button
        WebElement joinFormButton = driver.findElement(By.cssSelector(".btn.btn-primary.join-btn"));

        //Submit Form
        joinFormButton.click();
        //joinFormButton.submit(); //Also you can use .submit function instead of .click()

        //Assertion
        WebElement alert = driver.findElement(By.cssSelector(".uno-alert.error.hidden>p>strong"));
        assertThat(alert.getText(), is("Please enter your first name"));
    }


    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
