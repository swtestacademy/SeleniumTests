package alerts_windows_frames_tabs.windows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowManageTest {
    static WebDriver driver;
    private String url = "http://www.linkedin.com";

    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void WindowManageTest() {
        //1) Navigate to URL
        driver.navigate().to(url);

        //2) Maximize the window
        driver.manage().window().maximize();

        //3) Get size of the window and write the full screen size to the console
        Dimension windowSize = driver.manage().window().getSize();
        System.out.println("***Full Size Values for Current Window***\n");
        System.out.println("Screen Width: " + windowSize.getWidth() + "\n");
        System.out.println("Screen Height: " + windowSize.getHeight() + "\n");

        //4) Minimize the window by 1/4 and write the new screen size to the console
        driver.manage().window().setSize(new Dimension(windowSize.getWidth()/4,windowSize.getHeight()/4));
        Dimension quarterWindowSize = driver.manage().window().getSize();
        System.out.println("*** 1/4 Size Values for Current Window***\n");
        System.out.println("Screen Width: " + quarterWindowSize.getWidth() + "\n");
        System.out.println("Screen Height: " + quarterWindowSize.getHeight() + "\n");

        //5) Get window position and write it to the console
        Point windowPosition = driver.manage().window().getPosition();
        System.out.println("*** Window Position for Current Window***\n");
        System.out.println("Window X position: " + windowPosition.getX() + "\n");
        System.out.println("Window Y postition: " + windowPosition.getY() + "\n");

        //6) Set window position x=100 and y=200 and write to the console
        Point newWindowPosition = windowPosition.moveBy(200,200);
        driver.manage().window().setPosition(newWindowPosition);
        System.out.println("*** Window Position for Current Window***\n");
        System.out.println("Window X position: " + driver.manage().window().getPosition().getX() + "\n");
        System.out.println("Window Y postition: " + driver.manage().window().getPosition().getY() + "\n");
    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
