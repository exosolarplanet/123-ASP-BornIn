package com.revolut.Bornin.jpa;
//
//import com.revolut.Bornin.jpa.repository.BirthdayTableRepository;
//import com.revolut.Bornin.jpa.table.BirthdayTable;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import java.time.LocalDate;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@Ignore
//public class JpaTests {
//
//    @Autowired
//    private BirthdayTableRepository birthdayTableRepository;
//
//    private String username = "ece";
//    private LocalDate birthday = LocalDate.now().plusDays(2).minusYears(2);
//
//    @Test
//    void repositoryIsNotNull(){
//        assertThat(birthdayTableRepository).isNotNull();
//    }
//
//    @Test
//    void whenSaved_thenFindsByUsername(){
//        BirthdayTable birthdayTable = new BirthdayTable(
//                username,
//                birthday
//        );
//        birthdayTableRepository.save(birthdayTable);
//        assertThat(birthdayTableRepository.findByUsername(username)).isNotNull();
//        assertThat(birthdayTableRepository.findByUsername(username).getBirthday()).isEqualTo(birthday);
//
//    }
//
//
//}
