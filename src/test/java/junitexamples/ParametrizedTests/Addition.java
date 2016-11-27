package junitexamples.ParametrizedTests;

/**
 * Created by ONUR on 20.09.2015.
 */
public class Addition {
    public int AddOperation (int a, int b) {
        int result = a+b;
        System.out.println("Addition with: " + a + " + " + b  + " = " + result);
        return result;
    }
}
