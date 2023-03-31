package com.mycar.mycarapi.car;

import com.electronwill.nightconfig.core.conversion.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.fetchAllCars();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{vin}")
    public ResponseEntity<Car> getCarByVIN(@PathVariable("vin") String vin) {
        Car car = carService.fetchCarById(vin);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car carResponse = carService.addCar(car);

        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{vin}")
    public ResponseEntity<Car> createCarWithVIN(@PathVariable("vin") String vin, @RequestBody Car car) {
        Car carResponse = carService.addCarWithVIN(vin, car);

        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{vin}")
    public ResponseEntity<Map<String, Boolean>> updateCar(@PathVariable("vin") String vin, @RequestBody Car car) {
        carService.updateCar(vin, car);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{vin}")
    public ResponseEntity<Map<String, Boolean>> deleteCar(@PathVariable("vin") String vin) {
        carService.deleteCar(vin);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
