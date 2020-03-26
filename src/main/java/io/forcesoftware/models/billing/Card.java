package io.forcesoftware.models.billing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private String cardNumber;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String cardCvv;

    public static class Builder {

        private Card card;

        public Builder() {
            this.card = new Card();
        }

        public Builder(Card card) {
            this.card = card;
        }

        public Builder cardNumber(String cardNumber) {
            this.card.setCardNumber(cardNumber);
            return this;
        }

        public Builder cardExpiryMonth(String cardExpiryMonth) {
            this.card.setCardExpiryMonth(cardExpiryMonth);
            return this;
        }

        public Builder cardExpiryYear(String cardExpiryYear) {
            this.card.setCardExpiryYear(cardExpiryYear);
            return this;
        }

        public Builder cardCvv(String cardCvv) {
            this.card.setCardCvv(cardCvv);
            return this;
        }

        public Card build() {
            return card;
        }
    }
}
