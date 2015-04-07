package org.talangsoft.codingtest.addressbook.service;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;

import static org.junit.Assert.assertEquals;

public class GetHowManyDaysOlderTest extends AddressBookServiceTester{

    @Test(expected = PersonNotFoundException.class)
    public void howManyDaysOlderEmptyDBTest() {
        int daysOlder = service.howManyDaysOlderOneThanTheOtherByFirstName("Bill", "Paul");
        assertEquals(0, daysOlder);
    }

    @Test(expected = PersonNotFoundException.class)
    public void howManyDaysOlderPersonOneNotExists() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        int daysOlder = service.howManyDaysOlderOneThanTheOtherByFirstName("Bill", "Sarah");
        assertEquals(0, daysOlder);
    }


    @Test(expected = PersonNotFoundException.class)
    public void howManyDaysOlderPersonTwoNotExists() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        int daysOlder = service.howManyDaysOlderOneThanTheOtherByFirstName("Sarah", "Bill");
        assertEquals(0, daysOlder);
    }

    @Test
    public void howManyDaysOlderSameBirthday() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11)));
        addressBook.addPerson(new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1977, 11, 11)));

        int daysOlder = service.howManyDaysOlderOneThanTheOtherByFirstName("Sarah", "Gemma");
        assertEquals(0, daysOlder);
    }

    @Test
    public void howManyDaysOlderFirstIsOlderBirthday() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1976, 11, 11)));
        addressBook.addPerson(new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1977, 11, 11)));

        int daysOlder = service.howManyDaysOlderOneThanTheOtherByFirstName("Gemma", "Sarah");
        assertEquals(365, daysOlder);
    }

    @Test
    public void howManyDaysOlderFirstIsYoungerBirthday() {
        addressBook.addPerson(new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1976, 11, 11)));
        addressBook.addPerson(new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1977, 11, 11)));

        int daysOlder = service.howManyDaysOlderOneThanTheOtherByFirstName("Sarah", "Gemma");
        assertEquals(-365, daysOlder);
    }
}
