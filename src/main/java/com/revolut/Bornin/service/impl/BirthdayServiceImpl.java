package com.revolut.Bornin.service.impl;

import com.revolut.Bornin.jpa.table.BirthdayTable;
import com.revolut.Bornin.service.BirthdayService;
import com.revolut.Bornin.jpa.repository.BirthdayTableRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BirthdayServiceImpl implements BirthdayService {

    private final BirthdayTableRepository birthdayTableRepository;

    public BirthdayServiceImpl(BirthdayTableRepository birthdayTableRepository) {
        this.birthdayTableRepository = birthdayTableRepository;
    }

    @Override
    public LocalDate getBirthdayResults(String username){
        BirthdayTable birthdayTable = birthdayTableRepository.findByUsername(username);
        return birthdayTable.getBirthday();
    }

    @Override
    public Integer noOfDaysUntilBirthday(LocalDate birthday){
        Integer birthdayDayOfYear = birthday.getDayOfYear();
        Integer todayDayOfYear = LocalDate.now().getDayOfYear();
        if(todayDayOfYear > birthdayDayOfYear ){
            return 365 - (todayDayOfYear - birthdayDayOfYear);
        }
        return birthday.getDayOfYear() - LocalDate.now().getDayOfYear();
    }
}
