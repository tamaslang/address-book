package org.talangsoft.codingtest.addressbook.service;

public class PersonNotFoundException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Person with firstName '%s' not found";

    private String firstName;

    public PersonNotFoundException(String firstName) {
        super(String.format(MESSAGE_FORMAT, firstName));

        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}