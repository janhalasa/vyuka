package addressbook;

public class Address {
    
    public final String street;
    public final String number;
    public final String city;

    public Address(String street, String number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public String toString() {
        return street + " " + number + ", " + city;
    }
}
