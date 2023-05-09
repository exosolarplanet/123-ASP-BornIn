//package com.revolut.Bornin.Controller;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.hamcrest.Matchers.containsString;
//
//import com.revolut.Bornin.jpa.repository.BirthdayTableRepository;
//import com.revolut.Bornin.jpa.table.BirthdayTable;
//import com.revolut.Bornin.service.BirthdayService;
//import org.apache.catalina.core.ApplicationContext;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDate;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BirthdayControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private BirthdayTableRepository birthdayTableRepository;
//
//    @MockBean
//    private BirthdayService service;
//
//    private String username = "ece";
//
//    @Test
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(get("/health")).andDo(print()).andExpectAll(
//                status().isOk(),
//                content().string("healthy")
//        );
//    }
//
//    @Test
//    public void givenUsername_whenBirthdayIsInNDays_thenBirthdayControllerShouldReturnNoOfDaysUntilNextBirthday() throws Exception {
//        String expectedResponse = String.format("Hello, %s! Your birthday is in %d day(s)", username, 1);
//        LocalDate birthday = LocalDate.now().plusDays(1).minusYears(2);
//        when(service.getBirthdayResults(username)).thenReturn(birthday);
//        when(service.noOfDaysUntilBirthday(birthday)).thenReturn(1);
//
//        this.mockMvc.perform(get("/hello/ece")).andDo(print()).andExpectAll(
//                status().isOk(),
//                content().string(expectedResponse)
//        );
//    }
//
//    @Test
//    public void givenUsername_whenBirthdayIsToday_thenBirthdayControllerShouldCongratulateBirthday() throws Exception {
//        LocalDate birthday = LocalDate.now();
//        when(service.getBirthdayResults(username)).thenReturn(birthday);
//
//        String expectedResponse = String.format("Hello, %s! Happy birthday!",username);
//        this.mockMvc.perform(get("/hello/ece")).andDo(print()).andExpectAll(
//                status().isOk(),
//                content().string(expectedResponse)
//        );
//    }
//
//
//    @Test
//    public void givenUsername_whenUsernameDoesNotExist_thenBirthDayControllerShouldReturn4xxClientError() throws Exception {
//        when(service.getBirthdayResults(username)).thenThrow(NullPointerException.class);
//        this.mockMvc.perform(get("/hello/ece")).andDo(print()).andExpectAll(
//                status().is4xxClientError(),
//                content().string(containsString("No date of birth information"))
//        );
//    }
//
//    //Improve
//    @Test
//    public void givenUsernameAndDateOfBirth_whenUsernameIsValid_thenBirthdayControllerShouldReturn2xx() throws Exception {
//        LocalDate birthday = LocalDate.now().plusDays(1).minusYears(2);
//        birthdayTableRepository.save(new BirthdayTable(username, birthday));
//        assertThat(birthdayTableRepository.findByUsername(username).getBirthday()).isEqualTo(birthday);
//        this.mockMvc.perform(put("/hello/ece").queryParam("dateofBirth", birthday.toString())).andDo(print()).andExpectAll(
//                status().isOk(),
//                content().string("Birthday information saved!")
//        );
//    }
//
//    @Test
//    public void givenUsernameAndDateOfBirth_whenDateOfBirthIsInTheFuture_thenBirthdayControllerShouldReturn4xxClientError() throws Exception {
//        LocalDate birthday = LocalDate.now().plusDays(1).plusYears(2);
//        this.mockMvc.perform(put("/hello/ece").queryParam("dateofBirth", birthday.toString())).andDo(print()).andExpectAll(
//                status().is4xxClientError(),
//                content().string(containsString("You must write a book about time travelling"))
//        );
//    }
//
//    @Test
//    public void givenUsernameAndDateOfBirth_whenUsernameIsNotAllLetters_thenBirthdayControllerShouldReturn4xxClientError() throws Exception {
//        LocalDate birthday = LocalDate.now().plusDays(1).minusYears(2);
//        this.mockMvc.perform(put("/hello/ece123.!").queryParam("dateofBirth", birthday.toString())).andDo(print()).andExpectAll(
//                status().is4xxClientError(),
//                content().string("Please make sure username only includes letters")
//        );
//    }
//}
