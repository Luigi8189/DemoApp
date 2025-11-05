package com.example.cars.controller;

import com.example.cars.model.Car;
import com.example.cars.model.CarType;
import com.example.cars.repository.CarRepository;
import org.apache.coyote.Response;
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

    //Create
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        if (car.getModelName() == null || car.getType() == null || car.getColor() == null) {
            return ResponseEntity.badRequest().build();
        }
        Car saved = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //READ ALL
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    //READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE TYPE
    @PatchMapping("/{id}/type")
    public ResponseEntity<Car> updateCarType(@PathVariable Long id, @RequestParam CarType type) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build;
        }
        Car car = carRepository.findById(id).get();
        car.setType(type);
        return ResponseEntity.ok(carRepository.save(car));
    }

    //DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //DELETE ALL
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCars() {
        carRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}