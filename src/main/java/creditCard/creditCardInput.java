package creditCard;

import java.util.Date;

public class creditCardInput {
    private String CardNumber;
    private String ExpirationDate;
    private String NameOfCardholder;
    private String CardType;
    private String Error;
    private Date ExpDate;

    public creditCardInput(String CardNumber,String ExpirationDate,String NameOfCardholder){
        this.CardNumber = CardNumber;
        this.ExpirationDate =ExpirationDate;
        this.NameOfCardholder = NameOfCardholder;
        this.CardType = null;
        this.Error = null;
    }

    public creditCardInput(String CardNumber,String ExpirationDate,String NameOfCardholder, String CardType, String Error){
        this.CardNumber = CardNumber;
        this.ExpirationDate =ExpirationDate;
        this.NameOfCardholder = NameOfCardholder;
        this.CardType = CardType;
        this.Error = Error;
    }

    public String getCardNumber() {
        return this.CardNumber;
    }

    public Long getLongCardNumber() {
        return Long.parseLong( this.CardNumber );
    }

    public String getExpirationDate() {
        return this.ExpirationDate;
    }

    public String getNameOfCardholder() {
        return this.NameOfCardholder;
    }

    public String getCardType() {
        return this.CardType;
    }

    public void setCardType(String CardType) {
        this.CardType = CardType;
    }

    public String getError() {
        return this.Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    @Override
    public String toString() {
        return "CSV:  [CardNumber=" + this.CardNumber + ", ExpirationDate=" + this.ExpirationDate
                + ", NameOfCardholder=" + this.NameOfCardholder
                + ", CardType=" + this.CardType
                + ", Error=" + this.Error +"]";
    }
}

