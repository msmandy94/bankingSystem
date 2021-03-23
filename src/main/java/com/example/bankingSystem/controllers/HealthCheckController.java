package com.example.bankingSystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mandeep.singh on 12:52 AM 23/03/21 Tuesday
 */
@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public ResponseEntity<String> healthCheck() {

        return new ResponseEntity<>("ok", null, HttpStatus.OK);
    }
}
