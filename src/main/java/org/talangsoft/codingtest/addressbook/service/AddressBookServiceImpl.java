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
        if(addressBook.isEmpty()){
            return null;
        }
        final Comparator<Person> ageComparator = (p1 , p2) -> Long.compare(p1.getDateOfBirth().getMillis(),p2.getDateOfBirth().getMillis());
        return addressBook.getAllPersons().stream().min(ageComparator).get();
    }

    @Override
    public int howManyDaysOlderOneThanTheOtherByFirstName(String oneFirstName, String theOtherFirstName) {
        Person onePerson = addressBook.getFirstPersonByFirstName(oneFirstName);
        if(onePerson == null) {throw new PersonNotFoundException(oneFirstName);}

        Person theOtherPerson = addressBook.getFirstPersonByFirstName(theOtherFirstName);
        if(theOtherPerson == null) {throw new PersonNotFoundException(theOtherFirstName);}

        return Days.daysBetween(theOtherPerson.getDateOfBirth().toLocalDate(), onePerson.getDateOfBirth().toLocalDate()).getDays();
    }


}
