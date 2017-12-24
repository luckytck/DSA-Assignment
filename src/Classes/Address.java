
package Classes;

import java.io.Serializable;

public class Address implements Serializable{
    private String address;
    private String state;
    private String city;
    private int postcode;

    public Address() {
    }

    public Address(String address, String state, String city, int postcode) {
        this.address = address;
        this.state = state;
        this.city = city;
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return String.format("%-80s", address + ", " + postcode + " " + city + ", " + state);
    }
}
