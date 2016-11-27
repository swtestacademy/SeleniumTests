package junitexamples.junitrules;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ONUR on 15.09.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestFirstServer.class, TestSecondServer.class})
public class ServerTest {
    @ClassRule
    public static MyServer server = new MyServer();

    @Test
    public void testBlah() throws Exception {
        // test something that depends on the server.
    }
}
