package addressbook;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

    List<Person> persons = new LinkedList<>();

    public List<Person> findPersonsBySurname(String surname) {
        return this.persons.stream()
            .filter(person -> person.surname.equals(surname))
            .collect(Collectors.toList());
    }

    public List<Person> findPersonsByAddressCity(String city) {
        return this.persons.stream()
            .filter(person -> person.addresses.stream()
                .anyMatch(address -> address.city.equals(city)))
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        
        AddressBook addressBook = new AddressBook();
        addressBook.persons.addAll(List.of(
            new Person(
                "Carl",
                "Sagan",
                LocalDate.of(1938, 11, 23),
                List.of(
                    new Address("26th Avenue", "21", "New York"),
                    new Address("Rue de pont", "123b", "Paris")
                )),
            new Person(
                "Zuzana", 
                "Čaputová", 
                LocalDate.of(1973, 6, 21), 
                List.of(
                    new Address("Kvetinová", "108", "Pezinok"),
                    new Address("Prezidentská", "1", "Bratislava")
                )),
            new Person(
                "Tomáš", 
                "Masarique", 
                LocalDate.of(1973, 6, 21), 
                List.of(
                    new Address("Nábrežná", "27", "Bratislava"),
                    new Address("Place de la concorde", "22", "Paris"),
                    new Address("Brooklyn", "982", "New York")
                )),
            new Person(
                "Timothy", 
                "Snyder", 
                LocalDate.of(1969, 8, 18), 
                List.of(
                    new Address("Old street", "2", "Oxford")
                ))
        ));

        System.out.println("Zadaj mesto:");
        Scanner scanner = new Scanner(System.in);
        String cityToFind = scanner.nextLine();

        List<Person> personsByCity = addressBook.findPersonsByAddressCity(cityToFind);
        if (personsByCity.isEmpty()) {
            System.out.println("V danom meste nepoznám žiadneho človeka");
        } else {
            System.out.println("V danom meste poznám týchto ľudí:");
            for (Person person : personsByCity) {
                System.out.println(person);
            }
        }
    }
}