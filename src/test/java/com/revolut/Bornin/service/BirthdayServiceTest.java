package com.revolut.Bornin.service;

import com.revolut.Bornin.jpa.repository.BirthdayTableRepository;
import com.revolut.Bornin.jpa.table.BirthdayTable;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles(value={"test"})
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
