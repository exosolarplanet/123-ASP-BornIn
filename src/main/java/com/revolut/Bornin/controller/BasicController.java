package com.revolut.Bornin;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@RestController
public class BasicController {

    @GetMapping("health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("healthy");
    }
}

