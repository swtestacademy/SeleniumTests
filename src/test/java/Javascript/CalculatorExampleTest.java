package Javascript;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorExampleTest {
    static WebDriver driver;
    private static String url = "http://www.anaesthetist.com/mnm/javascript/calc.htm";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void calculatorJavaScriptTest() {
        //1-) Click "9"
        driver.findElement(By.name("nine")).click();

        //2-) Click "+"
        driver.findElement(By.name("add")).click();

        //3-) Click "3"
        driver.findElement(By.name("three")).click();

        //4-) Declare JavaScriptExecutor and call "Calculate()" function
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("Calculate();");

        //5-) Assert that result is 12
        WebElement result = driver.findElement(By.name("Display"));
        assertThat(result.getAttribute("value"), is("12"));
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
