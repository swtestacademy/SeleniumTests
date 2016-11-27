package Cookies;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CookieTest {
    static WebDriver driver;
    private static String url = "http://cookiedemo.com/default.asp";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void cookieTest() {
        //Synchronization
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //1) Go to http://cookiedemo.com/default.asp
        driver.navigate().to(url);

        //2) Get all the Cookies and print the total number of Cookies.
        printCookieNumber("First Time");

        //3) Click “I want mik with my cookie!”
        WebElement cookieButton = driver.findElement(By.cssSelector("input[type='submit']"));
        cookieButton.click();

        //4) Get the cookie which name is “cookie” with getName() method and print its value.
        Cookie cookie = driver.manage().getCookieNamed("cookie");
        System.out.println("cookie: " + cookie +"\n");
        System.out.println("cookie value: " + cookie.getValue().toString() + "\n");

        //5) Assert that cookie value is “Chocolate_Chip”
        assertTrue("Cookie does not contain 'Chocolate'", cookie.getValue().contains("Chocolate"));

        //6) Copy above cookie as copiedCookie and print it and total cookie number.
        Cookie copiedCookie = driver.manage().getCookieNamed("cookie");
        System.out.println("Copied cookie: " + copiedCookie +"\n");
        printCookieNumber("After Copying Cookie");//print cookie number after deleting cookie.

        //7) Create new Cookie as “myCookie” with Cookie.Builder and print it.
        Cookie buildedCookie = new Cookie.Builder("buildedCookie", "Cake")
                .domain(cookie.getDomain())
                .path( cookie.getPath())
                .expiresOn(cookie.getExpiry())
                .isSecure(cookie.isSecure()).build();
        System.out.println("Builded cookie: " + buildedCookie +"\n");

        //8) Delete the cookie
        driver.manage().deleteCookie(cookie);

        //9) print cookie number after deleting cookie.
        printCookieNumber("After Deleting Cookie");

        //10) Add new cookie by using “buildedCookie”
        driver.manage().addCookie(buildedCookie);

        //11) Add new cookie by using “copiedCookie”
        driver.manage().addCookie(copiedCookie);

        //12) Print cookie number after adding two cookies.
        printCookieNumber("After Adding Two Cookies");

        //13) Delete buildedCookie by using .deleteCookieName
        driver.manage().deleteCookieNamed("buildedCookie");

        //14) Delete copiedCookie by using .deleteCookie
        driver.manage().deleteCookie(copiedCookie);

        //15) Print cookie number after deleting two cookies.
        printCookieNumber("After Deleting Two Cookies");

        //16) Delete all cookies.
        driver.manage().deleteAllCookies();

        //17) Print cookie number after deleting all the cookies.
        printCookieNumber("After Deleting All Cookies");

        //18) Refresh page then select Ginderbread and click “I want milk with my cookie!” and click “Get a Cookie!” button.
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select"))); //Sync
        Select cookieSelect = new Select(driver.findElement(By.cssSelector("select"))); //Select Method Dropdown Options
        cookieSelect.selectByValue("Gingerbread");
        waitThenClick(wait, By.cssSelector("input[type=checkbox]")); //Wait and Click checkbox
        waitThenClick(wait, By.cssSelector("input[type='submit']")); //Wait and Click button

        //19) Get the cookie which name is “cookie” and assert that its value is “Ginderbread_milk” as shown below.
        assertThat(driver.manage().getCookieNamed("cookie").getValue(), allOf(startsWith("Gingerbread"), containsString("milk")));
    }

    private void printCookieNumber (String note) {
        Set<Cookie> cookies = driver.manage().getCookies();
        List<Cookie> cookiesList = new ArrayList<Cookie>(cookies); //Set to List Conversion
        System.out.println("Total number of Cookies ~~~" + note + "~~~ : " + cookiesList.size() + "\n");
    }

    private void waitThenClick (WebDriverWait wait, By findBy){
        wait.until(ExpectedConditions.elementToBeClickable(findBy)); //Wait Until an element to be clickable
        driver.findElement(findBy).click(); //Click
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
