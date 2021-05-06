package creditCard;


public class verifyCreditCardTypeAmex extends creditCardDataHandler {

    private creditCardDataHandler successor = null;

    public creditCard getCreditCard(){

        creditCard cc = new amexCard();
        return null;
    }

    public void setSuccessor(creditCardDataHandler next) {
        this.successor = next;
    }

    public creditCardInput verifyCreditCard(creditCardInput inputrow) {

        // First digit is a 3 and second digit a 4 or 7. Length is 15 digits.
        //System.out.println(inputrow.getCardNumber());
        if( inputrow.getCardNumber().length() == 15 && inputrow.getCardNumber().substring(0,1).equals("3"))
        {
            String secDigit = inputrow.getCardNumber().substring(1,2);
            if(secDigit.equals("4")  || secDigit.equals("7")) {
                inputrow.setCardType("AmericanExpress");
                inputrow.setError("None");

                getCreditCard();
            }
            else {
                if(this.successor != null) {
                    successor.verifyCreditCard(inputrow);
                }
            }
        }
        else {
            if(this.successor != null) {
                successor.verifyCreditCard(inputrow);
            }
        }
        return inputrow;
    }

}