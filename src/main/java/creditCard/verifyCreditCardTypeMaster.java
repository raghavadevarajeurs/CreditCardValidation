package creditCard;

public class verifyCreditCardTypeMaster extends creditCardDataHandler {

    private creditCardDataHandler successor = null;

    public  creditCard getCreditCard(){

        creditCard cc = new masterCard();
        return null;
    }

    public void setSuccessor(creditCardDataHandler next) {
        this.successor = next;
    }

    public creditCardInput verifyCreditCard(creditCardInput inputrow) {

        // First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.
        // System.out.println(inputrow.getCardNumber());
        String firstDigit = inputrow.getCardNumber().substring(0,1);
        if(firstDigit.equals("5")  && inputrow.getCardNumber().length() == 16)
        {
            int i = Integer.parseInt(inputrow.getCardNumber().substring(1,2));
            if(i >= 1 && i <= 5) {
                inputrow.setCardType("MasterCard");
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