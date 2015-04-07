package org.talangsoft.codingtest.addressbook.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.joda.time.LocalDate;

public class Person {
    String firstName;
    String lastName;
    Gender gender;
    LocalDate dateOfBirth;

    public Person() {
    }

    public Person(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("gender",gender)
                .add("dateOfBirth",dateOfBirth).toString();
    }
}
