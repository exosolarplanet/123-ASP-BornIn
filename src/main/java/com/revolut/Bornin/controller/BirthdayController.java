package com.revolut.Bornin.controller;

import com.revolut.Bornin.jpa.table.BirthdayTable;
import com.revolut.Bornin.service.BirthdayService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.time.LocalDate;

@RestController
public class BirthdayController {

    private final BirthdayService birthdayService;

    public BirthdayController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @PutMapping("/hello/{username}")
    public ResponseEntity<String> saveBirthday(@PathVariable String username, @RequestParam(name = "dateofBirth") LocalDate birthday ) {

        birthdayService.persistBirthdayResults(username, birthday);
        return ResponseEntity.ok("Birthday information saved!");

    }

    @GetMapping(value = "/hello/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBirthday(@PathVariable String username) throws JSONException {

        BirthdayTable birthdayTable = birthdayService.getBirthdayResults(username);
        if (birthdayTable.getBirthday().isAfter(LocalDate.now())){
            return ResponseEntity.ok(String.format("Hello, %s! Happy birthday!", birthdayTable.getUsername()));
        }
        Integer noDays = birthdayService.noOfDaysUntilBirthday(birthdayTable.getBirthday());
        JSONObject responseBody = new JSONObject();
        responseBody.put("message", String.format("Hello, %s! Your birthday is in %d day(s)",birthdayTable.getUsername(), noDays));
        return ResponseEntity.ok(String.format("Hello, %s! Your birthday is in %d day(s)",birthdayTable.getUsername(), noDays));

    }
}
