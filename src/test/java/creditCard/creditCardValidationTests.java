package creditCard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class creditCardValidationTests {
    creditCardValidation client = new creditCardValidation();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("###############################");
        System.out.println("Class: creditCardValidationTests");
    }

    @Test
    public void CSVFileExtensionTest() {
        System.out.println("Test : CSVFileExtensionTest");
        String fileName = "./inputFiles/Sample.csv";
        String  fileType = client.getFileType(fileName);
        assertEquals("csv", fileType);
    }

    @Test
    public void JSONFileExtensionTest() {
        System.out.println("Test : JSONFileExtensionTest");
        String fileName = "./inputFiles/Sample.json";
        String  fileType = client.getFileType(fileName);
        assertEquals("json", fileType);
    }

    @Test
    public void XMLFileExtensionTest() {
        System.out.println("Test : XMLFileExtensionTest");
        String fileName = "./inputFiles/Sample.xml";
        String  fileType = client.getFileType(fileName);
        assertEquals("xml", fileType);
    }

    @Test
    public void InvalidFileExtensionTest() {
        System.out.println("Test : InvalidFileExtensionTest");
        String fileName = "./inputFiles/Sample.tar";
        creditCardValidation client = new creditCardValidation();
        String  fileType = client.getFileType(fileName);
        assertNotEquals("New or invalid file type", fileType);
    }

    @Test
    public void isSameInOutFileExtTest() {
        System.out.println("Test : isSameInOutFileExtTest");
        String inFile = "./inputFiles/Sample.csv";
        String outFile = "./outputFiles/Out.csv";
        String outFile1 = "./outputFiles/Out.json";
        assertTrue("Input-Output File type matching", client.isSameInOutFileExt( inFile, outFile));
        assertFalse("Input-Output File type not matching", client.isSameInOutFileExt( inFile, outFile1));
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
    }

}