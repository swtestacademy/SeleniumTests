package navigation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ONUR on 04.10.2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NavigationTest {

    static WebDriver driver;
    final private String URL1 = "http://www.teknosa.com";
    final private String URL2 = "http://www.amazon.com";

    @BeforeClass
    public static void setupTest(){
        driver = new FirefoxDriver();
    }

    //.get Example
    @Test
    public void T01_getURLExample() {
        //Go to www.teknosa.com
        driver.get(URL1);

        //Check title is correct
        assertThat(driver.getTitle(), is("Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji"));
    }

    //.Navigate().to example
    @Test
    public void T02_navigateToExample(){
        //Go to www.amazon.com
        driver.navigate().to(URL2);

        //Check title is correct
        assertThat(driver.getTitle(), is("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
    }

    @Test
    //Back - Forward - Refresh Example
    public void T03_backForwardRefreshExample(){
        //Go to www.teknosa.com
        driver.navigate().to(URL1);
        //Check title is correct
        assertThat(driver.getTitle(), is("Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji"));

        //Go to www.amazon.com
        driver.navigate().to(URL2);
        //Check title is correct
        assertThat(driver.getTitle(), is("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));

        //***Navigate Back***
        driver.navigate().back();
        //Check title is correct
        assertThat(driver.getTitle(), is("Teknosa Alışveriş Sitesi - Herkes İçin Teknoloji"));

        //***Navigate Forward***
        driver.navigate().forward();
        //Check title is correct
        assertThat(driver.getTitle(), is("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));

        //***Refresh The Page***
        driver.navigate().refresh();
        assertThat(driver.getTitle(), is("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
