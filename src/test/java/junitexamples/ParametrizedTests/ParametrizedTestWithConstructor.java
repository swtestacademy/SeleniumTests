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
public class ParametrizedTestWithConstructor {
    //Private variables
    private int v1;
    private int v2;
    private int summation;

    //Constructor
    public ParametrizedTestWithConstructor(int p1, int p2, int p3) {
        this.v1 = p1;
        this.v2 = p2;
        this.summation = p3;
    }

    //Creating test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] dataValues = new Object[][] { { 4 , 3, 7 }, { 7, 8, 15 }, { 2, 9, 11} };
        return Arrays.asList(dataValues);
    }


    //Test addoperation method of class Addition
    @Test
    public void testAddition() {
            Addition add = new Addition();
            assertEquals("Addition Failed!", summation, add.AddOperation(v1, v2));
            System.out.println("Test for " + v1 + " and " + v2 + " has been passed!\n");
    }
}
