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
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ONUR on 11.10.2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FindByTest {
    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    //Find By.id Example
    @Test
    public void T01_findById() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.id method
        WebElement firstNameTextBox = driver.findElement(By.id("first-name"));

        //Assert that text box is empty
        assertThat(firstNameTextBox.getText(), is(""));
    }

    //Find By.name Example
    @Test
    public void T02_findByName() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.Name method
        WebElement firstNameTextBox = driver.findElement(By.name("firstName"));

        //Assert that text box is empty
        assertThat(firstNameTextBox.getText(), is(""));
    }

    //Find By.linkText Example
    @Test
    public void T03_findLinkText() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.LinkText method
        WebElement forgetPassLink = driver.findElement(By.linkText("Forgot password?"));

        //Assert that text box is empty
        assertThat(forgetPassLink.getText(), is("Forgot password?"));
    }

    //Find By.partialLinkText Example
    @Test
    public void T04_findpartialLinkText() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.partialLinkText method
        WebElement forgetPassLink = driver.findElement(By.partialLinkText("password?"));

        //Assert that text box is empty
        assertThat(forgetPassLink.getText(), is("Forgot password?"));
    }

    //Find By.className Example
    @Test
    public void T05_findclassName() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.className method
        List<WebElement> textInputClasses  = driver.findElements(By.className("cell-body-textinput"));

        int textInputClassCount = textInputClasses.size();

        //Assert that text box is empty
        assertThat(textInputClassCount, is(4));
    }

    //Find By.tagName Example
    @Test
    public void T06_findtagName() {
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        //Find first name text box by By.tagName method
        List<WebElement> h3Tags  = driver.findElements(By.tagName("h3"));

        int h3TagCount = h3Tags.size();

        //Assert that text box is empty
        assertThat(h3TagCount, is(6));
    }

/*    @Test
    public void T06_NoSuchElementExceptionTest(){
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        try{
            //Wrong locate operation
            WebElement notExistentElement = driver.findElement(By.id("BlaBlaBla"));
        } catch(NoSuchElementException e){
            // import org.openqa.selenium.NoSuchElementException;
            // and not the java.util.NoSuchElementException
        }
    }*/

    @Test
    public void T07_chainingWithFindElementMethods(){
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        WebElement element = driver.findElement(By.className("link")).
                                    findElement(By.linkText("About"));

        assertThat(element.getAttribute("href"), is("https://www.linkedin.com/about-us?trk=uno-reg-guest-home-about"));
    }

    @Test
    public void T08_chainingWithByChained(){
        //Navigate to Linkedin.com
        driver.navigate().to("https://www.linkedin.com/");

        WebElement element;
        element = driver.findElement(
                new ByChained(
                        By.className("link"),
                        By.linkText("About")));

        assertThat(element.getAttribute("href"), is("https://www.linkedin.com/about-us?trk=uno-reg-guest-home-about"));
    }


    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
