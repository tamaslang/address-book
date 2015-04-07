package org.talangsoft.codingtest.addressbook.context;

import com.google.common.base.Splitter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.talangsoft.codingtest.addressbook.domain.Gender;
import org.talangsoft.codingtest.addressbook.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse person lines with the format:
 * Wes Jackson, Male, 14/08/74
 */
public class PersonTextParser {

    public static final String DATE_OF_BIRTH_FORMAT= "dd/MM/yy";

    private static final DateTimeFormatter DATE_OF_BIRTH_FORMATTER = DateTimeFormat.forPattern(DATE_OF_BIRTH_FORMAT);
    public static final String PERSON_DATA_SEPARATOR = ",";
    public static final String NAME_SEPARATOR = " ";


    // Wes Jackson, Male, 14/08/74
    public static Person parsePersonLine(String personLine){
        List<String> personLineData = Splitter.on(PERSON_DATA_SEPARATOR).trimResults().splitToList(personLine);
        List<String> nameData = Splitter.on(NAME_SEPARATOR).trimResults().splitToList(personLineData.get(0));
        return new Person(nameData.get(0),nameData.get(1), parseGender(personLineData.get(1)),parseDateOfBirth(personLineData.get(2)));
    }

    public static List<Person> parsePersonLines(List<String> personLine){
        return personLine.stream().map(PersonTextParser::parsePersonLine).collect(Collectors.toList());
    }


    private static Gender parseGender(String gender){
       return Gender.valueOf(gender.toUpperCase());
    }

    private static DateTime parseDateOfBirth(String dateOfBirth){
        return DATE_OF_BIRTH_FORMATTER.parseDateTime(dateOfBirth);
    }
}
