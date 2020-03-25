package io.forcesoftware.models.billing;

public class Profile {

    private String alias;
    private String email;

    private Address shippingAddress;
    private Address billingAddress;

    private Card card;

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Card getCard() {
        return card;
    }
}
