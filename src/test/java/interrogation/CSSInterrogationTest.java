package interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CSSInterrogationTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    //Find First name text box with CSS Selector
    @Test
    public void T01_firstNameCSSSelector() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by CSS Selector
        WebElement firstNameTextBox = driver.findElement(By.cssSelector("#first-name"));

        //Assert that text box is empty
        assertThat(firstNameTextBox.getText(), is(""));
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}