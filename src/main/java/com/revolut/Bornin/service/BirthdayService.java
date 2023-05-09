package com.revolut.Bornin.service;

import java.time.LocalDate;

public interface BirthdayService {

    LocalDate getBirthdayResults(String username) throws Exception;

    Integer noOfDaysUntilBirthday(LocalDate birthday);
}
