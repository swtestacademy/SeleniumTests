package junitexamples.junitrules;

import org.junit.rules.ExternalResource;

/**
 * Created by ONUR on 15.09.2015.
 */
public class MyServer extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        // start the server
    }

    @Override
    protected void after() {
        // stop the server
    }
}

