package org.talangsoft.codingtest.addressbook.service;

import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;

/*
    Service interface methods
 */
public interface AddressBookService {
    /**
     * Count the nuber of persons with the given gender
     *
     * @param gender the gender to count persons with
     * @return the number of persons with the given gender
     */
    long countNrOfPersonsWithGender(Gender gender);


    /**
     * Get the oldest person from the addressbook
     *
     * @return the oldest person
     */
    Person getOldestPerson();


    /**
     * Get the difference in days between two person
     *
     * @return the number of days between the two person
     */
    int howManyDaysOlderOneThanTheOtherByFirstName(String one, String theOther);
}
