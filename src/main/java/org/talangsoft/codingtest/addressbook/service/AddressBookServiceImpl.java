package org.talangsoft.codingtest.addressbook.service;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;

import java.util.Comparator;

@Service("addressBookService")
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBook addressBook;

    @Override
    public long countNrOfPersonsWithGender(Gender gender) {
        return addressBook.getAllPersons().stream().filter(p -> p.getGender() == gender).count();
    }

    @Override
    public Person getOldestPerson() {
        if (addressBook.isEmpty()) {
            return null;
        }
        final Comparator<Person> ageComparator = (p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
        return addressBook.getAllPersons().stream().min(ageComparator).get();
    }

    @Override
    public int howManyDaysOlderOneThanTheOtherByFirstName(String oneFirstName, String theOtherFirstName) {
        Person onePerson = addressBook.getFirstPersonWithMatchingFirstName(oneFirstName);
        if (onePerson == null) {
            throw new PersonNotFoundException(oneFirstName);
        }

        Person theOtherPerson = addressBook.getFirstPersonWithMatchingFirstName(theOtherFirstName);
        if (theOtherPerson == null) {
            throw new PersonNotFoundException(theOtherFirstName);
        }

        return howManyDaysOlderOneThanTheOther(onePerson, theOtherPerson);
    }

    public int howManyDaysOlderOneThanTheOther(Person onePerson, Person theOtherPerson) {
        return Days.daysBetween(theOtherPerson.getDateOfBirth(), onePerson.getDateOfBirth()).getDays();
    }


}
