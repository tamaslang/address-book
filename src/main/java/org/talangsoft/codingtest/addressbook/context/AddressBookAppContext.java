package org.talangsoft.codingtest.addressbook.context;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.InMemoryAddressBook;
import org.talangsoft.codingtest.addressbook.fileinput.PersonTextParser;

import java.util.List;


/**
 * Created by admin on 07/04/15.
 */
@Configuration
@ComponentScan({"org.talangsoft.codingtest.addressbook"})
public class AddressBookAppContext implements ResourceLoaderAware {

    private DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yy");
    private ResourceLoader resourceLoader;

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    AddressBook addressBook() throws Exception {
        List<String> addressBookLines = TextFileResourceLoader.loadLines(resourceLoader, "classpath:AddressBook");
        AddressBook addressBook = new InMemoryAddressBook(PersonTextParser.parsePersonLines(addressBookLines));
        return addressBook;
    }
}
