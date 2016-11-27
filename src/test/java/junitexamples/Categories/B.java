package junitexamples.Categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by ONUR on 20.09.2015.
 */
@Category({SlowTests.class, FastTests.class})
public class B {
    @Test
    public void c() {
        System.out.println("c() method of class B has been run...\n");
    }
}

