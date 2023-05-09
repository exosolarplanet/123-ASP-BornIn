package com.revolut.Bornin.controller;

import com.revolut.Bornin.jpa.repository.BirthdayTableRepository;
import com.revolut.Bornin.jpa.table.BirthdayTable;
import com.revolut.Bornin.service.BirthdayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class BirthdayController {

    private final BirthdayService birthdayService;

    @Autowired
    private BirthdayTableRepository birthdayTableRepository;

    Logger logger = LoggerFactory.getLogger(BirthdayController.class);

    public BirthdayController(BirthdayService birthdayService) { this.birthdayService = birthdayService; }

    @PutMapping("/hello/{username}")
    public ResponseEntity<String> saveBirthday(@PathVariable String username, @RequestParam(name = "dateofBirth") LocalDate birthday ) {

        if (birthday.isAfter(LocalDate.now())) {
            logger.warn("Incorrect date of birth: date of birth is in the future");
            return ResponseEntity.badRequest().body(String.format("Are you sure %s is your birthday? You must write a book about time travelling!", birthday.toString()));
        }
        if(!username.chars().allMatch(Character::isLetter)){
            logger.warn("Incorrect username: username includes chars other than letters");
            return ResponseEntity.badRequest().body(String.format("Please make sure username only includes letters"));
        }

        try {
            birthdayTableRepository.save(new BirthdayTable(username, birthday));
        } catch(Exception e){
            return ResponseEntity.internalServerError().body("Unable to save date of birth");
        }

        return ResponseEntity.ok("Birthday information saved!"); //remove message

    }

    @GetMapping(value = "/hello/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBirthday(@PathVariable String username) throws Exception {
        LocalDate birthday = null;

        try {
            birthday = birthdayService.getBirthdayResults(username);
        }catch (NullPointerException e){
            e.getStackTrace();
            return ResponseEntity.badRequest().body(String.format("No date of birth information can be found for username %s", username));
        }

        Integer noDays = birthdayService.noOfDaysUntilBirthday(birthday);
        if ( noDays==0 ){
            return ResponseEntity.ok(String.format("Hello, %s! Happy birthday!", username));
        }
        return ResponseEntity.ok(String.format("Hello, %s! Your birthday is in %d day(s)",username, noDays));

    }
}
