package org.talangsoft.codingtest.addressbook.domain;

import java.util.List;

public interface AddressBook {
    void addPerson(Person person);
    void addPersons(List<Person> persons);
    void clear();
    List<Person> getAllPersons();
}
