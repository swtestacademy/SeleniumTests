package junitexamples.Categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by ONUR on 20.09.2015.
 */
public class A {
    @Test
    public void a() {
        System.out.println("a() method of class A has been run...\n");
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
        System.out.println("b() method of class A has been run...\n");
    }
}

