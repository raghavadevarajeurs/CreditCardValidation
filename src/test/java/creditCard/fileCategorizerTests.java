package creditCard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class fileCategorizerTests {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("###############################");
        System.out.println("Class: FileOrganizerTests");
    }

    @Test
    public void controllerTest() {
        System.out.println("Test : controllerTest");
        String inFile = "./inputFiles/Sample.csv";
        String outFile = "./outputFiles/Out.csv";
        String extension = "csv";
        assertTrue("File controller can parse file successfully", fileCategorizer.controller(inFile,outFile,extension));
    }


    @Test
    public void isValidDateTest() {
        //("MM/dd/yyyy", "M/y", "M/d/y", "M-d-y", "MMM-dd","dd-MMM", "dd-MMM-yyyy")
        System.out.println("Test : isValidDateTest");
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("12/01/2020"));
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("02/2020"));
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("1/1/2020"));
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("3-30-2020"));
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("Jan-20"));
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("20-Jan"));
        assertTrue("Valid Date Type", fileCategorizer.isDateValid("12-01-2020"));

        assertFalse("Valid Date Type", fileCategorizer.isDateValid("12-01/2020"));
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
    }

}
