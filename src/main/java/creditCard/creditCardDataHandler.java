package creditCard;


public abstract class creditCardDataHandler {

    private creditCardDataHandler successor = null;

    //abstract method: getCC()
    public abstract creditCard getCreditCard();

    public void setSuccessor(creditCardDataHandler next) {
        this.successor = next;
    }

    public creditCardInput verifyCreditCard(creditCardInput inputrow) {
        return null;
    }

}
