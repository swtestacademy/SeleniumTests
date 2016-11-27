package Cookies;

import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Date;


public class CookieBuilderTest {

    Date today = new Date();
    Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

    Cookie newCookie = new Cookie.Builder("myCookie","my value") //Name & value pair of the cookie (mandatory fields)
                                 .domain("www.swtestacademy.com") //Domain of the cookie
                                 .path("/") //Path of the cookie
                                 .expiresOn(tomorrow) //Expiration date
                                 .isSecure(true) //Is it secure or not?
                                 .build(); //Finally build it with .build() call
    @Test
    public void promptCookie (){
        System.out.println("My new Cookie: " + newCookie);
    }
}
