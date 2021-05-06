package creditCard;

public class verifyCreditCardTypeVisa extends creditCardDataHandler {

    private creditCardDataHandler successor = null;

    public creditCard getCreditCard() {

        creditCard cc = new visaCard();
        return null;
    }

    public void setSuccessor(creditCardDataHandler next) {
        this.successor = next;
    }

    public creditCardInput verifyCreditCard(creditCardInput inputrow) {

        //First digit is a 4. Length is either 13 or 16 digits.
        //System.out.println(inputrow.getCardNumbere());
        String firstDigit = inputrow.getCardNumber().substring(0, 1);
        int length = inputrow.getCardNumber().length();

        if ((firstDigit.equals("4") && length == 13) || (firstDigit.equals("4") && length == 16)) {
            inputrow.setCardType("Visa");
            inputrow.setError("None");

            getCreditCard();
        } else {
            if (this.successor != null) {
                successor.verifyCreditCard(inputrow);
            }
        }

        return inputrow;
    }
}