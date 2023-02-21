package com.br.cars.services;

import com.br.cars.models.CarModel;
import com.br.cars.repositories.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public CarModel addCar(CarModel car){
         Optional<CarModel> optionalCar = carRepository.findByNome(car.getNome());
         if (optionalCar.isPresent()){
             throw new RuntimeException("Car already exists in the database.");
         }
        return carRepository.save(new CarModel(car.getNome(), car.getAno(), car.getValorTabelaFipe()));
    }

    public CarModel findCarByName(String carName){
        Optional<CarModel> car = carRepository.findByNome(carName);
        if (car.isEmpty()){
            throw new RuntimeException("Car does not exist in the database.");
        }
        return car.get();
    }

    public List<CarModel> findAllCars() {
        Optional<List<CarModel>> cars = Optional.of(carRepository.findAll());
        if (!cars.isPresent()){
            throw new RuntimeException("There are no cars in the database.");
        }
        return cars.get();
    }

    @Transactional
    public void deleteCarByName(String nomeDoCarro) {
        Optional<CarModel> car = carRepository.findByNome(nomeDoCarro);
        if (car.isEmpty()){
            throw new RuntimeException("Car does not exist in the database.");
        }
        carRepository.delete(car.get());
    }

    @Transactional
    public void updateCarByName(String nomeDoCarro, CarModel car) {
        Optional<CarModel> optionalCar = carRepository.findByNome(nomeDoCarro);
        if (optionalCar.isEmpty()){
            throw new RuntimeException("Car does not exist in the database.");
        }
        CarModel carToUpdate = new CarModel(optionalCar.get().getId(),
                car.getNome(),
                car.getAno(),
                car.getValorTabelaFipe());
        carRepository.save(carToUpdate);
    }
}
