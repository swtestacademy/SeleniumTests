package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ONUR on 08.11.2015.
 */
public class CheckBoxTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void CheckBoxTest() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find "Keep me logged in" check box
        WebElement keepMeLoggedInCheckBox = driver.findElement(By.cssSelector("#persist_box"));

        //Check keepMeLoggedInCheckBox is Displayed, is Enabled, is NOT Selected
        assertTrue("keepMeLoggedInCheckBox is not displayed!", keepMeLoggedInCheckBox.isDisplayed());
        assertTrue("keepMeLoggedInCheckBox is not enabled!", keepMeLoggedInCheckBox.isEnabled());
        assertFalse("keepMeLoggedInCheckBox is selected!", keepMeLoggedInCheckBox.isSelected());

        //Click keepMeLoggedInCheckBox
        keepMeLoggedInCheckBox.click();

        //Check keepMeLoggedInCheckBox Displayed/Enabled/Selected
        assertTrue("keepMeLoggedInCheckBox is not displayed!",keepMeLoggedInCheckBox.isDisplayed());
        assertTrue("keepMeLoggedInCheckBoxis not enabled!",keepMeLoggedInCheckBox.isEnabled());
        assertTrue("keepMeLoggedInCheckBox is not selected!", keepMeLoggedInCheckBox.isSelected());
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
