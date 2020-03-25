package io.forcesoftware.models.billing;

public class Card {

    private String cardNumber;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String cardCvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiryMonth() {
        return cardExpiryMonth;
    }

    public String getCardExpiryYear() {
        return cardExpiryYear;
    }

    public String getCardCvv() {
        return cardCvv;
    }
}
