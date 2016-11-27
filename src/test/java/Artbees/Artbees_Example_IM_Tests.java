package Artbees;

import org.im4java.core.CompareCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by ONUR on 28.07.2016.
 */
public class Artbees_Example_IM_Tests {
    static WebDriver driver;
    static WebDriverWait wait;
    private static String url = "http://demos.artbees.net/jupiter5/pages/page-with-left-sidebar/";
    String currentDir = System.getProperty("user.dir");
    String screenShotsLocation = currentDir + "\\artbees\\ScreenShots\\";

    @Rule
    public TestName name = new TestName();

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
    }



    //IM compare Method
    boolean compareImages (String exp, String cur, String diff) throws Exception {
        //ProcessStarter.setGlobalSearchPath("C:\\Program Files\\ImageMagick-7.0.2-Q16");


        // This instance wraps the compare command
        CompareCmd compare = new CompareCmd();

        // For metric-output
        compare.setErrorConsumer(StandardStream.STDERR);
        IMOperation cmpOp = new IMOperation();
        // Set the compare metric
        //cmpOp.metric("mae");
        //cmpOp.metric("AE").fuzz(0.5);
        cmpOp.fuzz(0.5);
        cmpOp.metric("AE");

        // Add the expected image
        cmpOp.addImage(exp);

        // Add the current image
        cmpOp.addImage(cur);

        // This stores the difference
        cmpOp.addImage(diff);

        try {
            // Do the compare
            System.out.print("Compare öncesi\n");
            compare.run(cmpOp);
            //DisplayCmd.show(diff);
            System.out.print("\nCompare sonrası\n");
            return true;
        }
        catch (Exception ex) {
            System.out.print(ex);
            System.out.println ("\nComparison Failed!\n");
            throw ex;
            //return false;
        }
    }


    @Test
    public void First_Test_MoveToExampleTest() throws Exception {
        //SETUPS
        //Create a specific directory for a test
        String testScreenShotDirectory = screenShotsLocation + name.getMethodName() + "\\";
        File testDirectory = new File(testScreenShotDirectory);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        //BaseLine, Current, Difference Photo Paths
        String firstBaselinePhotoPath = testScreenShotDirectory + "firstBaselinePhoto.png";
        String firstCurrentPhotoPath = testScreenShotDirectory + "firstCurrentPhoto.png";
        String firstDifferencePath = testScreenShotDirectory + "firstDifference.png";

        System.out.print(firstBaselinePhotoPath + "\n" + firstCurrentPhotoPath + "\n" +firstDifferencePath +"\n");

        //TEST
        //Find Element
        //WebElement first_photo = driver.findElement(
        // By.cssSelector("a[href='//demos.artbees1.netdna-cdn.com/jupiter5/wp-content/uploads/2013/05/blog-16.jpg']"));
        WebElement first_photo = driver.findElement(By.cssSelector("section>article:nth-of-type(1)"));

        //Move To Operation
        Actions actions = new Actions(driver);
        actions.moveToElement(first_photo).perform();

        //Wait for 2 second for animation
        Thread.sleep(2000);

        //Take screenshot with Ashot
        //AShot JQuery screenshot capture is not working. Thus, I used webdriver's CoordsProvider method.
        //Screenshot firstPhotoScreenshot = new AShot().takeScreenshot(driver, first_photo);
        Screenshot firstImageScreenShot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,first_photo);


        String size = "Height: " + firstImageScreenShot.getImage().getHeight() + "\n" +
                      "Width: " + firstImageScreenShot.getImage().getWidth() + "\n";

        System.out.print("Size: " + size);


        //BaseLine, Current Photo Files
        File firstBaseLinePhoto = new File(firstBaselinePhotoPath);
        File firstCurrentPhoto = new File(firstCurrentPhotoPath);
        ImageIO.write(firstImageScreenShot.getImage(), "PNG", firstCurrentPhoto);

        //Did we capture baseline image before?
        if (firstBaseLinePhoto.exists()){
            //Compare screenshot with baseline
            //ImageDiff diff = new ImageDiffer().makeDiff(); //We can not do this AShot
            System.out.println("compare-1\n");
            //Try to use IM API for comparison

            boolean compareResult = compareImages(firstBaselinePhotoPath,firstCurrentPhotoPath,firstDifferencePath);

            if(compareResult==true) {
                System.out.println ("\nComparison Passed!\n");
            }
            System.out.println("compare-2\n");

        } else {
            System.out.println("bastır 1\n");
            //Put the screenshot to the specified folder
            ImageIO.write(firstImageScreenShot.getImage(), "PNG", firstBaseLinePhoto);

        }







        //Click first photo
        first_photo.click();

        //Wait until presence of container and check display
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector(".fancybox-image")));

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".fancybox-image")));

        driver.findElement(By.cssSelector(".fancybox-image")).isDisplayed();








/*        //Get the selected date text before AJAX call
        String selectedDateTextBeforeAjaxCall = driver.findElement
                (By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextBeforeAjaxCall to the console
        System.out.println("selectedDateTextBeforeAjaxCall: " + selectedDateTextBeforeAjaxCall +"\n" );

        //Find 3rd January on the calendar
        WebElement thirdOfJanuary = driver.findElement(By.xpath("./*//*[contains(@class, 'rcWeekend')]/a[.='3']"));

        //Click 3rd January
        thirdOfJanuary.click();

        //Wait until invisibility of loader
        new WebDriverWait(driver,10).until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));

        //Wait until visibility of selected date text
        //Actually it is not necessary, I added this control to see an example of visibilityOfElementLocated usage.
        new WebDriverWait(driver,10).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ContentPlaceholder1_Label1")));

        //Find Selected Dates Text
        String selectedDateTextAfterAjaxCall = driver.findElement(
                By.cssSelector("#ctl00_ContentPlaceholder1_Label1")).getText().trim();

        //Print selectedDateTextAfterAjaxCall to the console
        System.out.println("selectedDateTextAfterAjaxCall: " + selectedDateTextAfterAjaxCall + "\n");

        //Check the Actual and Expected Text
        assertThat(selectedDateTextAfterAjaxCall, is("Sunday, January 03, 2016"));*/


    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
