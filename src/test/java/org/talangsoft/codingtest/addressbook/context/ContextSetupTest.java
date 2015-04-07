package org.talangsoft.codingtest.addressbook.context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.talangsoft.codingtest.addressbook.service.AddressBookService;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookAppContext.class)
public class ContextSetupTest {

    @Autowired
    private AddressBookService service;

    @Test
    public void contextSetupTest() {
        assertNotNull(service);
    }
}
