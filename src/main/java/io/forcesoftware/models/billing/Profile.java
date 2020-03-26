package io.forcesoftware.models.billing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public boolean isSameShippingAndBilling() {
        return shippingAddress != null && billingAddress == null;
    }

    public static class Builder {

        private Profile profile;

        public Builder() {
            this.profile = new Profile();
        }

        public Builder(Profile profile) {
            this.profile = profile;
        }

        public Builder alias(String alias) {
            profile.setAlias(alias);
            return this;
        }

        public Builder email(String email) {
            profile.setEmail(email);
            return this;
        }

        public Builder shippingAddress(Address address) {
            profile.setShippingAddress(address);
            return this;
        }

        public Builder billingAddress(Address address) {
            profile.setBillingAddress(address);
            return this;
        }

        public Builder card(Card card) {
            profile.setCard(card);
            return this;
        }

        public Profile build() {
            return profile;
        }
    }
}
