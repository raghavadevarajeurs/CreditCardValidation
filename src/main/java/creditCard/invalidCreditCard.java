package creditCard;

import java.util.regex.Pattern;

public class invalidCreditCard extends creditCardDataHandler {
    private creditCardDataHandler successor = null;

    public  creditCard getCreditCard(){

        return null;
    }

    public void setSuccessor(creditCardDataHandler next) {
        this.successor = next;
    }

    public creditCardInput verifyCreditCard(creditCardInput inputrow) {


        //Credit card numbers cannot exceed 19 digits;

        Pattern pattern = Pattern.compile("[a-zA-Z]*"); //special character and character check
        //Matcher match = pattern.matcher(inputrow.getCardNumbere());
        //boolean b = m.find();

        //if((inputrow.getCardNumbere().length() > 19 || inputrow.getCardNumbere().length() <= 0) || pattern.matcher(inputrow.getCardNumbere()).find())
        // if((inputrow.getCardNumbere().length() > 19 || inputrow.getCardNumbere().length() <= 0) || inputrow.getCardNumbere().matches("[A-Za-z]+"))
        if((inputrow.getCardNumber().length() > 19 || inputrow.getCardNumber().length() <= 0) || !inputrow.getCardNumber().matches("[0-9]+"))
        {
            inputrow.setCardType("Invalid");
            inputrow.setError("Error");
        }
        else {
            if(this.successor != null) {
                successor.verifyCreditCard(inputrow);
            }
        }


        return inputrow;
    }
}
