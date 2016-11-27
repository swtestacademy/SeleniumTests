package Examples.YoutubeFileSubmit;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Created by ONUR on 21.12.2015.
 */
public class YoutubeFileSubmitTest {

    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() throws MalformedURLException {
        driver = new FirefoxDriver();
    }

    @Test
    public void SubmitVideoToYoutubeTest() throws URISyntaxException {
        //Navigate to http://www.youtube.com/
        driver.manage().window().maximize();
        driver.navigate().to("http://www.youtube.com/");

        //Test file decleration
        File testFile = new File(this.getClass().getResource("/test_video.avi").toURI());

        //Click to Upload
        WebElement uploadButton = driver.findElement(By.id("upload-btn"));
        uploadButton.click();

        //Login


        //Click to "Select files to upload" (Browse) button
        WebElement browseButton = driver.findElement(By.id("#sb-button-notify"));

        //Select test file operation
        browseButton.sendKeys(testFile.getAbsolutePath());


/*        //Wait until upload text is (xpath: ./*//*[@id='upload-item-0']/div[3]/div[1]/div[2]/div[2]/div[2]/span[2])


        //Click publish button  Css: .yt-uix-button.yt-uix-button-size-default.save-changes-button.yt-uix-tooltip.yt-uix-button-primary
        submitButton.click();

        //Check the result
        WebElement resultText = driver.findElement(By.cssSelector("html>body>h3:nth-of-type(2)"));
        System.out.println("resulttext: " + resultText.getText());
        assertTrue("test_file.txt is not submitted!", resultText.getText().contains("test_file"));*/
    }


}
