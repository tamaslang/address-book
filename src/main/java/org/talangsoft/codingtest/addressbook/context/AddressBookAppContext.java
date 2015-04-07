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

@Configuration
@ComponentScan({"org.talangsoft.codingtest.addressbook"})
public class AddressBookAppContext implements ResourceLoaderAware {

    public static final String DATE_OF_BIRTH_FORMAT = "dd/MM/yy";
    public static final String ADDRESS_BOOK_LOCATION = "classpath:AddressBook";

    private DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_OF_BIRTH_FORMAT);
    private ResourceLoader resourceLoader;

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    AddressBook addressBook() throws Exception {
        List<String> addressBookLines = TextFileResourceLoader.loadLines(resourceLoader, ADDRESS_BOOK_LOCATION);
        AddressBook addressBook = new InMemoryAddressBook(PersonTextParser.parsePersonLines(addressBookLines));
        return addressBook;
    }
}
