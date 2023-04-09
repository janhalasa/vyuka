package addressbook;

import java.time.LocalDate;
import java.util.List;

public class Person {
    
    public final String givenName;
    public final String surname;
    public final LocalDate dateOfBirth;
    public final List<Address> addresses;

    public Person(String givenName, String surname, LocalDate dateOfBirth, List<Address> addresses) {
        this.givenName = givenName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.addresses = addresses;
    }

    public String toString() {
        return givenName + " " + surname + " " + dateOfBirth + " " + addresses;
    }
}
