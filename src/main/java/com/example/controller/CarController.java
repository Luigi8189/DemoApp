package com.example.controller;

import com.example.model.Car;
import com.example.model.CarType;
import com.example.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        if (car.getModelName() == null || car.getType() == null || car.getColor() == null) {
            return ResponseEntity.badRequest().build();
        }
        Car saved = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/type")
    public ResponseEntity<Car> updateCarType(@PathVariable Long id, @RequestParam CarType type) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Car car = carRepository.findById(id).get();
        car.setType(type);
        return ResponseEntity.ok(carRepository.save(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllCars() {
        carRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}