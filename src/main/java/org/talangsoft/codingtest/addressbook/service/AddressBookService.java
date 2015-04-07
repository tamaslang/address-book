package org.talangsoft.codingtest.addressbook.service;

import org.talangsoft.codingtest.addressbook.domain.Gender;

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
}
