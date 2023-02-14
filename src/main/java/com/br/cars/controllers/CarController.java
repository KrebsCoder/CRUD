package com.br.cars.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carros")
public class CarController {

    @GetMapping
    public ResponseEntity<Object> getCarsName(){
        return ResponseEntity.status(HttpStatus.OK).body("Test");
    }
}
