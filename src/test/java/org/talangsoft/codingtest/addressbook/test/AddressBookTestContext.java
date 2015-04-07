package org.talangsoft.codingtest.addressbook.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.InMemoryAddressBook;


/**
 * Test application context; initalize an empty address book
 */
@Configuration
@ComponentScan({"org.talangsoft.codingtest.addressbook"})
public class AddressBookTestContext {

    @Bean
    AddressBook addressBook() throws Exception {
        return new InMemoryAddressBook();
    }
}
