package org.talangsoft.codingtest.addressbook;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.talangsoft.codingtest.addressbook.context.AddressBookAppContext;
import org.talangsoft.codingtest.addressbook.domain.AddressBook;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.service.AddressBookService;

public class AddressBookApp {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AddressBookAppContext.class);
        applicationContext.refresh();

        AddressBookService service = (AddressBookService) applicationContext.getBean("addressBookService");
        AddressBook database = (AddressBook) applicationContext.getBean(AddressBook.class);

        System.out.println("Address Book coding task");
        System.out.println("DATA:");
        database.getAllPersons().stream().forEach(System.out::println);
        System.out.println("Q&A:");
        System.out.print("1. How many males are in the address book? ");
        System.out.println(service.countNrOfPersonsWithGender(Gender.MALE));
        System.out.print("2. Who is the oldest person in the address book? ");
        System.out.println(service.getOldestPerson().getFirstName());
        System.out.print("3. How many days older is Bill than Paul? ");
        System.out.println(service.howManyDaysOlderOneThanTheOtherByFirstName("Bill","Paul"));
    }
}
