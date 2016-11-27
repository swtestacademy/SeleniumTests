package manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ONUR on 08.11.2015.
 */
public class DropDownTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void T01_DropDownTestWithDirectAccessToOptions() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Dropdown Options
        WebElement monthDropDownOption = driver.findElement(By.cssSelector("#month>option[value='10']"));
        WebElement dayDropDownOption = driver.findElement(By.cssSelector("#day>option[value='29']"));
        WebElement yearDropDownOption = driver.findElement(By.cssSelector("#year>option[value='1990']"));

        //Click keepMeLoggedInCheckBox
        monthDropDownOption.click();
        dayDropDownOption.click();
        yearDropDownOption.click();

        /*//Check options are Selected Correctly
        assertThat("monthDropDownOption is not OCT!", monthDropDownOption.getText(), is("Oct"));
        assertThat("dayDropDownOption is not 29!", dayDropDownOption.getText(), is("29"));
        assertThat("yearDropDownOption is not 1990!", yearDropDownOption.getText(), is("1990"));*/
    }

    @Test
    public void T02_DropDownTestWithChainOfFindElements() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Dropdown Selects
        WebElement monthDropDownSelect = driver.findElement(By.cssSelector("#month"));
        WebElement dayDropDownSelect = driver.findElement(By.cssSelector("#day"));
        WebElement yearDropDownSelect = driver.findElement(By.cssSelector("#year"));

        //Find Dropdown Options
        WebElement monthDropDownOption = monthDropDownSelect.findElement(By.cssSelector("option[value='10']"));
        WebElement dayDropDownOption = dayDropDownSelect.findElement(By.cssSelector("option[value='29']"));
        WebElement yearDropDownOption = yearDropDownSelect.findElement(By.cssSelector("option[value='1990']"));

        //Click keepMeLoggedInCheckBox
        monthDropDownOption.click();
        dayDropDownOption.click();
        yearDropDownOption.click();

        /*//Check options are Selected Correctly
        assertThat("monthDropDownOption is not OCT!", monthDropDownOption.getText(), is("Oct"));
        assertThat("dayDropDownOption is not 29!", dayDropDownOption.getText(), is("29"));
        assertThat("yearDropDownOption is not 1990!", yearDropDownOption.getText(), is("1990"));*/
    }

    @Test
    public void T03_DropDownTestWithSelectByIndex() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Dropdown Selects
        WebElement monthDropDownSelect = driver.findElement(By.cssSelector("#month"));
        WebElement dayDropDownSelect = driver.findElement(By.cssSelector("#day"));
        WebElement yearDropDownSelect = driver.findElement(By.cssSelector("#year"));

        //Select Method Dropdown Options
        Select monthSelect = new Select(monthDropDownSelect);
        monthSelect.selectByIndex(10);

        Select daySelect = new Select(dayDropDownSelect);
        daySelect.selectByIndex(29);

        Select yearSelect = new Select(yearDropDownSelect);
        yearSelect.selectByIndex(26);


        //Check options are Selected Correctly
        assertThat("monthDropDownOption is not OCT!", monthSelect.getFirstSelectedOption().getText(), is("Oct"));
        assertThat("dayDropDownOption is not 29!", daySelect.getFirstSelectedOption().getText(), is("29"));
        assertThat("yearDropDownOption is not 1990!", yearSelect.getFirstSelectedOption().getText(), is("1990"));
    }

    @Test
    public void T04_DropDownTestWithSelectByValue() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Dropdown Selects
        WebElement monthDropDownSelect = driver.findElement(By.cssSelector("#month"));
        WebElement dayDropDownSelect = driver.findElement(By.cssSelector("#day"));
        WebElement yearDropDownSelect = driver.findElement(By.cssSelector("#year"));

        //Select Method Dropdown Options
        Select monthSelect = new Select(monthDropDownSelect);
        monthSelect.selectByValue("10");

        Select daySelect = new Select(dayDropDownSelect);
        daySelect.selectByValue("29");

        Select yearSelect = new Select(yearDropDownSelect);
        yearSelect.selectByValue("1990");


        //Check options are Selected Correctly
        assertThat("monthDropDownOption is not OCT!", monthSelect.getFirstSelectedOption().getText(), is("Oct"));
        assertThat("dayDropDownOption is not 29!", daySelect.getFirstSelectedOption().getText(), is("29"));
        assertThat("yearDropDownOption is not 1990!", yearSelect.getFirstSelectedOption().getText(), is("1990"));
    }

    @Test
    public void T05_DropDownTestWithSelectByVisibleTest() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Dropdown Selects
        WebElement monthDropDownSelect = driver.findElement(By.cssSelector("#month"));
        WebElement dayDropDownSelect = driver.findElement(By.cssSelector("#day"));
        WebElement yearDropDownSelect = driver.findElement(By.cssSelector("#year"));

        //Select Method Dropdown Options
        Select monthSelect = new Select(monthDropDownSelect);
        monthSelect.selectByVisibleText("Oct");

        Select daySelect = new Select(dayDropDownSelect);
        daySelect.selectByVisibleText("29");

        Select yearSelect = new Select(yearDropDownSelect);
        yearSelect.selectByVisibleText("1990");


        //Check options are Selected Correctly
        assertThat("monthDropDownOption is not OCT!", monthSelect.getFirstSelectedOption().getText(), is("Oct"));
        assertThat("dayDropDownOption is not 29!", daySelect.getFirstSelectedOption().getText(), is("29"));
        assertThat("yearDropDownOption is not 1990!", yearSelect.getFirstSelectedOption().getText(), is("1990"));
    }



    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
