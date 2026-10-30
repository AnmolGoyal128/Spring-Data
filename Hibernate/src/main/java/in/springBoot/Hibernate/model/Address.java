package in.springBoot.Hibernate.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseName;
    private String city;
    private String state;
    private String pinCode;

    public Address() {
    }

    public Address(String houseName, String city, String state, String pinCode) {
        this.houseName = houseName;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
