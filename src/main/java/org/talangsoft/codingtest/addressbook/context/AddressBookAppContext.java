package org.talangsoft.codingtest.addressbook.context;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.InMemoryAddressBook;
import org.talangsoft.codingtest.addressbook.domain.Person;

import java.util.List;


/**
 * Created by admin on 07/04/15.
 */
@Configuration
@ComponentScan({"org.talangsoft.codingtest.addressbook"})
public class AddressBookAppContext implements ResourceLoaderAware{

    private DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yy");

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private ResourceLoader resourceLoader;

    @Bean
    AddressBook addressBook() throws Exception{
        List<String> addressBookLines = TextFileResourceLoader.loadLines(resourceLoader,"classpath:AddressBook");
        AddressBook addressBook = new InMemoryAddressBook(PersonTextParser.parsePersonLines(addressBookLines));
        //addressBook.addPerson(new Person("Bill","McKnight",Gender.MALE,fmt.parseDateTime("16/03/77")));
        return addressBook;
    }
}
