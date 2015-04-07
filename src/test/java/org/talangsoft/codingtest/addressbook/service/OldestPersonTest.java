package org.talangsoft.codingtest.addressbook.service;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class OldestPersonTest extends AddressBookServiceTester{

    @Test
    public void getOldestPersonForEmpty() {
        assertNull(service.getOldestPerson());
    }

    @Test
    public void getOldestPersonFor1Person() {
        Person onlyPerson = new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11));
        addressBook.addPerson(onlyPerson);
        assertEquals(onlyPerson, service.getOldestPerson());
    }

    @Test
    public void getOldestPersonFor2PeopleOlderAddedFirst() {
        Person older = new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11));
        Person younger = new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1980, 11, 11));
        addressBook.addPerson(older);
        addressBook.addPerson(younger);
        assertEquals(older, service.getOldestPerson());
    }

    @Test
    public void getOldestPersonFor2PeopleYoungetAddedFirst() {
        Person older = new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11));
        Person younger = new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1980, 11, 11));
        addressBook.addPerson(younger);
        addressBook.addPerson(older);

        assertEquals(older, service.getOldestPerson());
    }

    @Test
    public void getOldestPersonFor2PeopleSameAge() {
        Person first = new Person("Sarah", "Stone", Gender.FEMALE, new LocalDate(1977, 11, 11));
        Person second = new Person("Gemma", "Lane", Gender.FEMALE, new LocalDate(1977, 11, 11));
        addressBook.addPerson(first);
        addressBook.addPerson(second);

        assertEquals(first, service.getOldestPerson());
    }
}
