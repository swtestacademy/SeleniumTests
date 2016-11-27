package Synchronization;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SecondSyncTest {
    static WebDriver driver;
    private static String url = "http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void SecondSyncTest() {
        //Declare a Webdriver Wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //Wait until presence of container
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(".demo-container.size-narrow")));

        //Get the selected date text before AJAX call
        String selectedDateTextBeforeAjaxCall = driver.findElement
                (By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextBeforeAjaxCall to the console
        System.out.println("selectedDateTextBeforeAjaxCall: " + selectedDateTextBeforeAjaxCall +"\n" );

        //Find 3rd January on the calendar
        WebElement thirdOfJanuary = driver.findElement(By.xpath(".//*[contains(@class, 'rcWeekend')]/a[.='3']"));

        //Click 3rd January
        thirdOfJanuary.click();

        //Wait until invisibility of loader
        new WebDriverWait(driver,10).until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));


        //Find Selected Dates Text
        String selectedDateTextAfterAjaxCall = driver.findElement(
                By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextAfterAjaxCall to the console
        System.out.println("selectedDateTextAfterAjaxCall: " + selectedDateTextAfterAjaxCall +"\n" );

        //Check the Expected and Actual Text
        assertThat("Sunday, January 03, 2016", is(selectedDateTextAfterAjaxCall));

        //Now, click 4th of Jan and wait 5th of Jan is clickable and then click 5th of Jan
        //Find 4th and 5th of January on the calendar  rcSelected
        WebElement fourthOfJanuary = driver.findElement(By.cssSelector(".rcRow>td[title='Monday, January 04, 2016']"));

        //Click 4th of January
        fourthOfJanuary.click();

        //Wait until invisibility of loader
        new WebDriverWait(driver,10).until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));

        //Click 5th of January
        WebElement fifthOfJanuary = driver.findElement(By.cssSelector(".rcRow>td[title='Tuesday, January 05, 2016']"));
        fifthOfJanuary.click();

        //Wait until invisibility of loader
        new WebDriverWait(driver,10).until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));

        //Wait until visibility of selected date text
        new WebDriverWait(driver,10).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")));

        //Get selectedDateTextAfterAjaxCall
        selectedDateTextAfterAjaxCall = driver.findElement(
                By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Check the Actual Text contains "Tuesday, January 05, 2016"
        assertThat(selectedDateTextAfterAjaxCall, is(containsString("Tuesday, January 05, 2016")));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}




