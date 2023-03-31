package com.mycar.mycarapi.car;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getAll();
    String create(Car car) throws MyCarBadRequestException;
    void update(String id, Car car) throws MyCarBadRequestException;
    void delete(String id) throws MyCarResourceNotFoundException;
    Optional<Car> getByVIN(String vin) throws MyCarResourceNotFoundException;
}
