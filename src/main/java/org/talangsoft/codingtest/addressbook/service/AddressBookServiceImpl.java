package org.talangsoft.codingtest.addressbook.service;

import org.springframework.stereotype.Service;
import org.talangsoft.codingtest.addressbook.domain.Gender;

@Service("addressBookService")
public class AddressBookServiceImpl implements AddressBookService {
    @Override
    public int countNrOfPersonsWithGender(Gender gender) {
        return 0;
    }
}
