package com.mycar.mycarapi.car;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> fetchAllCars();
    Optional<Car> addCar(Car car) throws MyCarBadRequestException;
    void updateCar(String id, Car car) throws MyCarBadRequestException;
    void deleteCar(String id) throws MyCarResourceNotFoundException;
    Car fetchCarById(String id) throws MyCarResourceNotFoundException;
}
