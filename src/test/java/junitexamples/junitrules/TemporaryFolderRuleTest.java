package junitexamples.junitrules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by ONUR on 12.09.2015.
 */
public class TemporaryFolderRuleTest {
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testFile() throws Exception {
        File testFolder = tempFolder.newFolder("TestFolder");
        File testFile = tempFolder.newFile("test.txt");
        assertTrue(testFolder.exists());
        assertTrue(testFile.exists());
        //Do something else...
    }
}
