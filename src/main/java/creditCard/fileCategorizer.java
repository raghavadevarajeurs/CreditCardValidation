package creditCard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class fileCategorizer {
//abstract methods
    public abstract List<creditCardInput> readFile(String fileName);
    public abstract void writeFile(String fileName, List<creditCardInput> creditCardList);

    public fileCategorizer() {}

    public static Boolean controller(String inputFile, String outputFile, String extension) {
        List<creditCardInput> creditCardList = new ArrayList<creditCardInput>();

        if(extension.equals("csv")) {
            System.out.println("\nRead CSV file:");
            creditCardList= new fileHandlerCSV().readFile(inputFile);

            creditCardList = creditCardHandler(creditCardList);
            System.out.println("Write CSV file:");
            new fileHandlerCSV().writeFile(outputFile,creditCardList);
            return true;
        }
        else if(extension.equals("json")) {
            System.out.println("\nRead JSON file:");
            creditCardList= new fileHandlerJSON().readFile(inputFile);

            creditCardList = creditCardHandler(creditCardList);
            System.out.println("\nWrite JSON file:");
            new fileHandlerJSON().writeFile(outputFile, creditCardList);

            return true;
        }
        else if(extension.equals("xml")) {

            System.out.println("\nRead XML file:");
            creditCardList = new fileHandlerXML().readFile(inputFile);

            creditCardList = creditCardHandler(creditCardList);
            System.out.println("\nWrite Xml file:");
            new fileHandlerXML().writeFile(outputFile, creditCardList);
            return true;
        }
        else  {
            System.out.println("New or invalid file type ");
            return false;
        }

    }

    // test case not applicable ; handler method of strategic pattern/chain of responsibility
    public static List<creditCardInput> creditCardHandler(List<creditCardInput> creditCardList) {
        creditCardDataHandler creditCard0 = new invalidCreditCard();
        creditCardDataHandler creditCard1 = new verifyCreditCardTypeVisa();
        creditCardDataHandler creditCard2 = new verifyCreditCardTypeMaster();
        creditCardDataHandler creditCard3 = new verifyCreditCardTypeAmex();
        creditCardDataHandler creditCard4 = new verifyCreditCardTypeDiscover();

        //set successor
        creditCard0.setSuccessor(creditCard1);
        creditCard1.setSuccessor(creditCard2);
        creditCard2.setSuccessor(creditCard3);
        creditCard3.setSuccessor(creditCard4);

        System.out.println("\n"+"----Credit Card Object Creation:-----"+"\n");
        for( creditCardInput inputRow : creditCardList ){

            inputRow = creditCard0.verifyCreditCard(inputRow);
            //System.out.println(inputRow.toString());
        }
        System.out.println("-------------------------------------");
        return creditCardList;
    }

    public static boolean isDateValid(String dateString) {
        // DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        // sdf.setLenient(true);
        // try {
        //     sdf.parse(dateString);
        // } catch (ParseException e) {
        //     return false;
        // }
        // return true;
        //---------------------
        List<String> formatStrings = Arrays.asList("MM/dd/yyyy", "M/y", "M/d/y", "M-d-y", "MMM-dd","dd-MMM", "dd-MMM-yyyy");
        for (String formatString : formatStrings)
        {
            try{
                new SimpleDateFormat(formatString).parse(dateString);
                return true;
            }
            catch (ParseException e) {

            }
        }
        return false;
    }

}
