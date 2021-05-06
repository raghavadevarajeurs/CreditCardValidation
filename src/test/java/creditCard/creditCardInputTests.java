package creditCard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class creditCardInputTests {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("###############################");
        System.out.println("Class: InputDataTests");
    }

    @Test
    public void getLongCardNumberTest() {
        creditCardInput inputRow = new creditCardInput("4100000000000000","6/20/2030","Richard");
        Long val = inputRow.getLongCardNumber() ;
        assertEquals(4100000000000000L,4100000000000000L);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
    }
}