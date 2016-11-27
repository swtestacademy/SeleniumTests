package junitexamples.ParametrizedTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by ONUR on 20.09.2015.
 */
@RunWith(Parameterized.class)
public class ParametrizedTestWithParameterAnnotation {
    //Private variables
    //Variables using together with @Parameter must be public
    @Parameterized.Parameter (value=0)
    public int v1;
    @Parameterized.Parameter (value=1)
    public int v2;
    @Parameterized.Parameter (value=2)
    public int summation;

    //Creating test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 4 , 3, 7 }, { 7, 8, 15 }, { 2, 9, 11 } };
        return Arrays.asList(data);
    }

    //Test addoperation method of class Addition
    @Test
    public void testAddition() {
        Addition add = new Addition();
        assertEquals("Addition Failed!", summation, add.AddOperation(v1, v2));
        System.out.println("Test for " + v1 + " and " + v2 + " has been passed!\n");
    }
}
