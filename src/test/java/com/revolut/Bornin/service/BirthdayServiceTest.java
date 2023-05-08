package com.revolut.Bornin.service;

import com.revolut.Bornin.controller.BirthdayController;
import com.revolut.Bornin.jpa.repository.BirthdayTableRepository;
import com.revolut.Bornin.jpa.table.BirthdayTable;
import com.revolut.Bornin.service.impl.BirthdayServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BirthdayServiceTest {

    @Autowired
    private BirthdayService service;

    @MockBean
    private BirthdayTableRepository birthdayTableRepository;

    private String username = "ece";
    private LocalDate birthday = LocalDate.now().plusDays(2).minusYears(2);


    @Test
    void givenUsername_whenGetBirthdayResultsIsInvoked_thenShouldReturnBirthdayResults() throws Exception {
        when(birthdayTableRepository.findByUsername(username)).thenReturn(new BirthdayTable(username, birthday));
        assertThat(service.getBirthdayResults(username)).isEqualTo(birthday);

    }

    @Test
    void givenBirthday_whenNoOfDaysUntilBirthDayInvoked_thenShouldReturnNoDaysLeftUntilBirthday(){
        assertThat(service.noOfDaysUntilBirthday(birthday)).isNotNull();
        assertThat(service.noOfDaysUntilBirthday(birthday)).isEqualTo(2);

    }
}
