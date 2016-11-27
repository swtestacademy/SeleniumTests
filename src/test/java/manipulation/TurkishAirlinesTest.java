package manipulation;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TurkishAirlinesTest {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.turkishairlines.com/tr-tr/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testTest() throws Exception {
        selenium.open("http://www.turkishairlines.com/en-int/");
        selenium.select("id=ctlCity", "label=Istanbul Ataturk Airport");
        selenium.click("css=option[value='IST,IST']");
        selenium.click("css=div.right > div.form-item > span.search.float-left");
        selenium.select("css=div.right > div.form-item > span.airport_selector_form > span.frm_element.fe2 > #ctlCity", "label=Kayseri Airport");
        selenium.click("css=div.right > div.form-item > span.airport_selector_form > span.frm_element.fe2 > #ctlCity > option[value='ASR,ASR']");
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
