package com.mycar.mycarapi.car;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;

    @Override
    public List<Car> fetchAllCars() {
        return carDao.getAll();
    }

    @Override
    public Optional<Car> addCar(Car car) throws MyCarBadRequestException {
        return Optional.empty();
    }

    @Override
    public void updateCar(String id, Car car) throws MyCarBadRequestException {

    }

    @Override
    public void deleteCar(String id) throws MyCarResourceNotFoundException {

    }

    @Override
    public Car fetchCarById(String id) throws MyCarResourceNotFoundException {
        return null;
    }
}
