package alerts_windows_frames_tabs.windows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WindowHandlesTest {
    static WebDriver driver;
    private String url = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void WindowHandlesTest() {
        //1) Navigate to URL
        driver.navigate().to(url);
        driver.manage().window().maximize();

        //2) Get the current window's handle and write to the console window. It must be first window handle.
        System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");

        //Switch to iframeResult iframe because all elements located in this iframe
        driver.switchTo().frame("iframeResult");

        //3) Locate the link and click it
        WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        visitLink.click();

        //4) Get all window handles and hold them in a list.
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandles); //Set to List Conversion

        //5) Write to total window handle number to the console.
        System.out.println("Total window number: " + windowHandlesList.size() + "\n");

        //6) Switch to second window
        driver.switchTo().window(windowHandlesList.get(1));

        //7) Get the current window's handle and write to the console window. It must be second window handle.
        System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");

        //8) Check the upper left side text is "THE WORLD'S LARGEST WEB DEVELOPER SITE" in second window
        WebElement expectedText = driver.findElement(By.cssSelector(".w3-right.toptext.w3-wide"));
        assertThat("THE WORLD'S LARGEST WEB DEVELOPER SITE", is(expectedText.getText()));

        //9) Go back (Switch) to first window
        driver.switchTo().window(windowHandlesList.get(0));

        //10) Get the current window's handle and write to the console window. It must be first window handle.
        System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");

        //11) Check the See Result Button Text
        WebElement seeResultButton = driver.findElement(By.cssSelector(".seeResult"));
        assertThat(seeResultButton.getText(), containsString("See Result"));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
