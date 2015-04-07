package org.talangsoft.codingtest.addressbook;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.talangsoft.codingtest.addressbook.context.AddressBookAppContext;
import org.talangsoft.codingtest.addressbook.service.AddressBookService;

public class AddressBookApp {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AddressBookAppContext.class);
        applicationContext.refresh();

        AddressBookService abs = (AddressBookService) applicationContext.getBean("addressBookService");
    }
}
