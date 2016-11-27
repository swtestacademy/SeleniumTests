package junitexamples.Categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ONUR on 20.09.2015.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Categories.ExcludeCategory(FastTests.class)
@Suite.SuiteClasses( { A.class, B.class }) // Note that Categories is a kind of Suite
public class SlowTestSecondSuite {
    // Will run A.b, but not A.a or B.c
}

