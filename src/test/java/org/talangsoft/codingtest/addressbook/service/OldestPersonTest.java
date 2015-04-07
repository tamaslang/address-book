package org.talangsoft.codingtest.addressbook.service;

import org.joda.time.DateTime;
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
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookTestContext.class)
public class OldestPersonTest {

    @Autowired
    private AddressBookService service;

    @Autowired
    private AddressBook addressBook;

    @Before
    public void setUp(){
        addressBook.clear();
    }

    @Test
    public void serviceSetupTest(){
        assertNotNull(service);
    }

    @Test
    public void getOldestPersonForEmpty(){
        assertNull(service.getOldestPerson());
    }


    @Test
    public void getOldestPersonFor1PersonDB(){
        Person onlyPerson = new Person("Sarah","Stone",Gender.FEMALE,new DateTime(1977,11,11,11,11,11));
        addressBook.addPerson(onlyPerson);
        assertEquals(onlyPerson,service.getOldestPerson());
    }

}
