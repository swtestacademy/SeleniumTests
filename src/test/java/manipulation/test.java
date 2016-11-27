package manipulation;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;

public class test {

    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }


    @Test
    //@Ignore("without waits this will only work in debug mode")
    public void manipulation1stTry(){

        driver.navigate().to("http://compendiumdev.co.uk/selenium/" +
                "basic_ajax.html");

        // select Server
        driver.findElement(By.cssSelector("option[value='3']")).click();

        // click Java in the language dropdown
        driver.findElement(By.cssSelector("option[value='23']")).click();

        driver.findElement(By.name("submitbutton")).click();

        WebElement languageWeUsed = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals("Expected Java code", "23",languageWeUsed.getText());
    }


}
