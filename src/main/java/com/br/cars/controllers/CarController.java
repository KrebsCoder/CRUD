package com.br.cars.controllers;

import com.br.cars.models.CarModel;
import com.br.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carros")
public class CarController {

    final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Object> getCars(){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findAllCars());
    }
    @GetMapping("/{NomeDoCarro}")
    public ResponseEntity<Object> getCarByName(@PathVariable String NomeDoCarro){
        return ResponseEntity.status(HttpStatus.OK).body(carService.findCarByName(NomeDoCarro));
    }

    @PostMapping
    public ResponseEntity<Object> addCar(@RequestBody CarModel car){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(car));
    }

    @DeleteMapping("/{NomeDoCarro}")
    public ResponseEntity<Object> deleteCar(@PathVariable String NomeDoCarro){
        carService.deleteCarByName(NomeDoCarro);
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted successfully.");
    }
}
