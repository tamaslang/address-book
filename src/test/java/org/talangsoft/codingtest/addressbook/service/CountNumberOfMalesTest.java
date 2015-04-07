package org.talangsoft.codingtest.addressbook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.talangsoft.codingtest.addressbook.context.AddressBookAppContext;
import org.talangsoft.codingtest.addressbook.domain.Gender;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookAppContext.class)
public class CountNumberOfMalesTest {

    @Autowired
    private AddressBookService service;

    @Test
    public void serviceSetupTest(){
        assertNotNull(service);
    }


    @Test
    public void countNrOfMales(){
        assertEquals(3, service.countNrOfPersonsWithGender(Gender.MALE));
    }
}
