package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by ONUR on 08.11.2015.
 */
public class RadioButtonTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void RadioButtonTest() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");

        //Find Radio Buttons
        WebElement maleRadioButton = driver.findElement(By.cssSelector("#u_0_o"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("#u_0_n"));

        //Click maleRadioButton
        maleRadioButton.click();

        //Check maleRadioButton Displayed/Enabled/Selected
        assertTrue("Male radio button is not displayed!",maleRadioButton.isDisplayed());
        assertTrue("Male radio button is not enabled!",maleRadioButton.isEnabled());
        assertTrue("Male radio button is not selected!",maleRadioButton.isSelected());

        //Click femaleRadioButton
        femaleRadioButton.click();

        //Check femaleRadioButton Displayed/Enabled/Selected
        assertTrue("Male radio button is not displayed!",femaleRadioButton.isDisplayed());
        assertTrue("Male radio button is not enabled!",femaleRadioButton.isEnabled());
        assertTrue("Male radio button is not selected!",femaleRadioButton.isSelected());
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}

