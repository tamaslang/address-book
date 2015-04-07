package org.talangsoft.codingtest.addressbook.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.test.AddressBookTestContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressBookTestContext.class)
public abstract class AddressBookServiceTester {
    @Autowired
    protected AddressBookService service;

    @Autowired
    protected AddressBook addressBook;

    @Before
    public void setUp() {
        addressBook.clear();
    }

}
