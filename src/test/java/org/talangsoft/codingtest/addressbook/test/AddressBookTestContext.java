package org.talangsoft.codingtest.addressbook.test;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.talangsoft.codingtest.addressbook.context.TextFileResourceLoader;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.InMemoryAddressBook;
import org.talangsoft.codingtest.addressbook.fileinput.PersonTextParser;

import java.util.List;


/**
 * Test application context; initalize an empty address book
 */
@Configuration
@ComponentScan({"org.talangsoft.codingtest.addressbook"})
public class AddressBookTestContext{

    @Bean
    AddressBook addressBook() throws Exception{
        return new InMemoryAddressBook();
    }
}
