package org.talangsoft.codingtest.addressbook.service;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;

import static org.junit.Assert.assertEquals;

public class CountNumberOfMalesTest extends AddressBookServiceTester{

    @Test
    public void countNrOfMalesForEmpty() {
        assertEquals(0, service.countNrOfPersonsWithGender(Gender.MALE));
    }

    @Test
    public void countNrOfMalesForOnlyFemales() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        addressBook.addPerson(new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        assertEquals(0, service.countNrOfPersonsWithGender(Gender.MALE));
    }

    @Test
    public void countNrOfMalesForOnlyMales() {
        addressBook.addPerson(new Person("Bill", "McKnight", Gender.MALE, new LocalDate(1977, 11, 11)));
        addressBook.addPerson(new Person("Paul", "Robinson", Gender.MALE, new LocalDate(1977, 11, 11)));
        assertEquals(2, service.countNrOfPersonsWithGender(Gender.MALE));
    }

    @Test
    public void countNrOfMalesForMalesAndFemalesTest() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        addressBook.addPerson(new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        addressBook.addPerson(new Person("Bill", "McKnight", Gender.MALE, new LocalDate(1977, 11, 11)));
        addressBook.addPerson(new Person("Paul", "Robinson", Gender.MALE, new LocalDate(1977, 11, 11)));
        assertEquals(2, service.countNrOfPersonsWithGender(Gender.MALE));
    }
}
