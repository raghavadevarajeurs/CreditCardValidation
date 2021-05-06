package creditCard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static  org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class verifyCreditCardNumberTests {

    //This class verifies all methods from all the chain of command classes that validates CC nums

    @BeforeClass
    public static void beforeClass() {
        System.out.println("###############################");
        System.out.println("Class: verifyCreditCardNumberTests");
    }

    @Test
    public void verifyInvalidCardCreditTest() {
        System.out.println("Test : verifyInvalidCardCreditTest");
        creditCardInput inputRow, outputRow;
        invalidCreditCard cc = new invalidCreditCard();

        inputRow = new creditCardInput("5100000a000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Invalid", outputRow.getCardType());

        inputRow = new creditCardInput("qwed","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Invalid", outputRow.getCardType());
    }

    @Test
    public void verifyCreditCardTypeVisaTest() {
        //Visa CC: First digit is a 4. Length is either 13 or 16 digits.
        System.out.println("Test : verifyCreditCardTypeVisaTest");
        creditCardInput inputRow, outputRow;
        verifyCreditCardTypeVisa cc = new verifyCreditCardTypeVisa();

        inputRow = new creditCardInput("4100000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Visa", outputRow.getCardType());

        inputRow = new creditCardInput("4000000000001","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Visa", outputRow.getCardType());

        inputRow = new creditCardInput("4000000000001999","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Visa", outputRow.getCardType());
        assertNotEquals("Invalid", outputRow.getCardType());
    }

    @Test
    public void verifyCreditCardTypeMasterTest() {
        //Master CC: First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits..
        System.out.println("Test : verifyCreditCardTypeMasterTest");
        creditCardInput inputRow, outputRow;
        verifyCreditCardTypeMaster cc = new verifyCreditCardTypeMaster();

        inputRow = new creditCardInput("5100000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());

        inputRow = new creditCardInput("5200000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());

        inputRow = new creditCardInput("5300000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());

        inputRow = new creditCardInput("5400000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());

        inputRow = new creditCardInput("5500000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("MasterCard", outputRow.getCardType());
        assertNotEquals("Invalid", outputRow.getCardType());
    }

    @Test
    public void verifyCreditCardTypeAmexCTest() {
        //AmEX: First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
        System.out.println("Test : verifyCreditCardTypeAmexCTest");
        creditCardInput inputRow, outputRow;
        verifyCreditCardTypeAmex cc = new verifyCreditCardTypeAmex();

        inputRow = new creditCardInput("340000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("AmericanExpress", outputRow.getCardType());

        inputRow = new creditCardInput("370000000000000","6/20/2030","Richard");
        assertEquals("AmericanExpress", outputRow.getCardType());
        assertNotEquals("Invalid", outputRow.getCardType());
    }

    @Test
    public void verifyCreditCardTypeDiscoverTest() {
        //Discover cc: First four digits are 6011. Length is 16 digits..
        System.out.println("Test : verifyCreditCardTypeDiscoverTest");
        creditCardInput inputRow, outputRow;
        verifyCreditCardTypeDiscover cc = new verifyCreditCardTypeDiscover();

        inputRow = new creditCardInput("6011000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Discover", outputRow.getCardType());

        inputRow = new creditCardInput("601100000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());

        inputRow = new creditCardInput("6110000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());

        inputRow = new creditCardInput("5400000000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());

        inputRow = new creditCardInput("55000sdg000000000","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertNotEquals("Discover", outputRow.getCardType());
        assertEquals("Invalid", outputRow.getCardType());

        inputRow = new creditCardInput("$%&*","6/20/2030","Richard");
        outputRow = cc.verifyCreditCard(inputRow);
        assertEquals("Invalid", outputRow.getCardType());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("###############################");
    }

}