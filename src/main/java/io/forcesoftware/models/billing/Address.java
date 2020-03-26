package io.forcesoftware.models.billing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String firstName;
    private String lastName;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String zip;
    private String state;
    private String phone;

    public static class Builder {

        private Address address;

        public Builder() {
            address = new Address();
        }

        public Builder(Address address) {
            this.address = address;
        }

        public Builder firstName(String firstName) {
            this.address.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            this.address.setLastName(lastName);
            return this;
        }

        public Builder addressOne(String addressOne) {
            this.address.setAddressOne(addressOne);
            return this;
        }

        public Builder addressTwo(String addressTwo) {
            this.address.setAddressTwo(addressTwo);
            return this;
        }

        public Builder city(String city) {
            this.address.setCity(city);
            return this;
        }

        public Builder zip(String zip) {
            this.address.setZip(zip);
            return this;
        }

        public Builder state(String state) {
            this.address.setState(state);
            return this;
        }

        public Builder phone(String phone) {
            this.address.setPhone(phone);
            return this;
        }

        public Address build() {
            return address;
        }
    }
}
