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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookTestContext.class)
public class GetHowManyDaysOlderTest {
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
