package com.revolut.Bornin.service;

import com.revolut.Bornin.jpa.table.BirthdayTable;

import java.time.LocalDate;

public interface BirthdayService {

    void persistBirthdayResults(String username, LocalDate birthday);

    BirthdayTable getBirthdayResults(String username);

    Integer noOfDaysUntilBirthday(LocalDate birthday);
}
