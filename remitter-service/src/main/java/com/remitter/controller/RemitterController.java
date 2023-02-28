package com.remitter.controller;

import com.remitter.entity.Remitter;
import com.remitter.exception.RemitterPropertiesCanNotBeNullException;
import com.remitter.service.RemitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/remitter")
@Slf4j
public class RemitterController {

    @Autowired
    private RemitterService remitterService;

    @PostMapping("/register")
    public ResponseEntity<Remitter> registerRemitter(@RequestBody Remitter remitter) {
        log.info("registerRemitter() method of RemitterController is called.");
        if(remitter.getName().equals("") || remitter.getEmailId().equals("") || remitter.getPassword().equals("")
                || remitter.getAddress().equals("")) {
            log.warn("Remitter properties can not be empty");
            throw new RemitterPropertiesCanNotBeNullException("Remitter Properties can not be empty");
        }
        Remitter registeredRemitter = remitterService.registerRemitter(remitter);
        return new ResponseEntity<>(registeredRemitter, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Remitter> getByEmailIdAndPassword(@RequestBody Remitter remitter) {
        log.info("getByEmailIdAndPassword() method of RemitterController is called");
        if(remitter.getEmailId().equals("") || remitter.getPassword().equals("")) {
            log.warn("Please enter both email and password");
            throw new RemitterPropertiesCanNotBeNullException("Please enter both email and password");
        }
        Remitter remitter1 = remitterService.getRemitterByEmailAndPassword(remitter.getEmailId(), remitter.getPassword());
        return new ResponseEntity<>(remitter1, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Remitter>> getAllRemitters() {
        log.info("getAllRemitters() method of RemitterController is called");
        List<Remitter> remitters = remitterService.getAllRemitters();
        return new ResponseEntity<>(remitters, HttpStatus.OK);
    }
}
