package org.talangsoft.codingtest.addressbook.fileinput;

import com.google.common.base.Splitter;
import org.joda.time.LocalDate;
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

    public static final String DATE_OF_BIRTH_FORMAT = "dd/MM/yy";
    public static final String PERSON_DATA_SEPARATOR = ",";
    public static final String NAME_SEPARATOR = " ";
    public static final int FIRSTNAME_INDEX = 0;
    public static final int LASTNAME_INDEX = 1;

    private static final DateTimeFormatter DATE_OF_BIRTH_FORMATTER = DateTimeFormat.forPattern(DATE_OF_BIRTH_FORMAT);
    public static final int NAME_COL_INDEX = 0;
    public static final int GENDER_COL_INDEX = 1;
    public static final int DATEOFBIRTH_COL_INDEX = 2;

    // Wes Jackson, Male, 14/08/74
    public static Person parsePersonLine(String personLine) {
        List<String> personLineData = Splitter.on(PERSON_DATA_SEPARATOR).trimResults().splitToList(personLine);
        List<String> nameData = Splitter.on(NAME_SEPARATOR).trimResults().splitToList(personLineData.get(NAME_COL_INDEX));
        return new Person(nameData.get(FIRSTNAME_INDEX), nameData.get(LASTNAME_INDEX),
                parseGender(personLineData.get(GENDER_COL_INDEX)),
                parseDateOfBirth(personLineData.get(DATEOFBIRTH_COL_INDEX)));
    }

    public static List<Person> parsePersonLines(List<String> personLine) {
        return personLine.stream().map(PersonTextParser::parsePersonLine).collect(Collectors.toList());
    }


    private static Gender parseGender(String gender) {
        return Gender.valueOf(gender.toUpperCase());
    }

    private static LocalDate parseDateOfBirth(String dateOfBirth) {
        return DATE_OF_BIRTH_FORMATTER.parseDateTime(dateOfBirth).toLocalDate();
    }
}
