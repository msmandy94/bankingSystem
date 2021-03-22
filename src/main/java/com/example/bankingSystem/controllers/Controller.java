package com.example.bankingSystem.controllers;

import com.example.bankingSystem.Dtos.Dummy;
import com.example.bankingSystem.Dtos.SignInRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mandeep.singh on 12:52 AM 23/03/21 Tuesday
 */
@RestController
@RequestMapping("/api")
public class Controller {

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
    public ResponseEntity<String> healthCheck() {

        return new ResponseEntity<>("ok", null, HttpStatus.OK);
    }

    @RequestMapping(value = "/healthCheck2", method = RequestMethod.GET)
    public ResponseEntity<Dummy> healthCheck2() {
        Dummy dummy = new Dummy();
        dummy.setName("mandeep");
        return new ResponseEntity<>(dummy, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseEntity<Object> signIn(@RequestBody SignInRequest request) {
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }
}
