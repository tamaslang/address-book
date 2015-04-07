package org.talangsoft.codingtest.addressbook.service;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;
import org.talangsoft.codingtest.addressbook.test.AddressBookTestContext;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookTestContext.class)
public class OldestPersonTest {

    @Autowired
    private AddressBookService service;

    @Autowired
    private AddressBook addressBook;

    @Before
    public void setUp() {
        addressBook.clear();
    }

    @Test
    public void serviceSetupTest() {
        assertNotNull(service);
    }

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
