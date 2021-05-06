package creditCard;

public class verifyCreditCardTypeDiscover extends creditCardDataHandler {

    private creditCardDataHandler successor = null;

    public  creditCard getCreditCard(){

        creditCard cc = new discoverCard();
        return null;
    }

    public void setSuccessor(creditCardDataHandler next) {
        this.successor = next;
    }

    public creditCardInput verifyCreditCard(creditCardInput inputrow) {

        // First four digits are 6011. Length is 16 digits..
        //System.out.println(inputrow.getCardNumbere());
        String firstSubStr = null;
        if(inputrow.getCardNumber().length() >= 4) {
            firstSubStr = inputrow.getCardNumber().substring(0,4);
        }

        if(inputrow.getCardNumber().length() == 16 && firstSubStr.equals("6011"))
        {
            inputrow.setCardType("Discover");
            inputrow.setError("None");

            getCreditCard();
        }
        else {
            inputrow.setCardType("Invalid");
            inputrow.setError("Error");
        }

        return inputrow;
    }

}