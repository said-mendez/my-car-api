package com.mycar.mycarapi.car;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;

import java.util.List;

public interface CarService {
    List<Car> fetchAllCars();
    Car addCar(Car car) throws MyCarBadRequestException;
    void updateCar(String id, Car car) throws MyCarResourceNotFoundException;
    void deleteCar(String id) throws MyCarResourceNotFoundException;
    Car fetchCarById(String id) throws MyCarResourceNotFoundException;
    Car addCarWithVIN(String id, Car car) throws MyCarBadRequestException;
}
