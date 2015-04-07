package org.talangsoft.codingtest.addressbook.domain;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAddressBook implements AddressBook {

    List<Person> persons = new ArrayList<>();

    public InMemoryAddressBook(List<Person> persons) {
        this.persons = persons;
    }

    public InMemoryAddressBook() {
        addPersons(persons);
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public void addPersons(List<Person> persons) {
        persons.addAll(persons);
    }

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public void clear() {
        persons.clear();
    }

    @Override
    public boolean isEmpty() {
        return persons.isEmpty();
    }

    @Override
    public Person getFirstPersonWithMatchingFirstName(String firstName) {
        if (persons.isEmpty()) {
            return null;
        }
        return persons.stream().filter(p -> p.getFirstName().equals(firstName)).findFirst().orElse(null);
    }
}
