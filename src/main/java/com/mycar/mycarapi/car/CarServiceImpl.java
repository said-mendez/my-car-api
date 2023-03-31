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
    public Car addCar(Car car) throws MyCarBadRequestException {
        String vin = carDao.create(car);

        return fetchCarById(vin);
    }

    @Override
    public void updateCar(String id, Car car) throws MyCarResourceNotFoundException {
        fetchCarById(id);
        carDao.update(id, car);
    }

    @Override
    public void deleteCar(String id) throws MyCarResourceNotFoundException {
        fetchCarById(id);
        carDao.delete(id);
    }

    @Override
    public Car fetchCarById(String id) throws MyCarResourceNotFoundException {
        return carDao.getByVIN(id)
                .orElseThrow(() -> new MyCarResourceNotFoundException("Car not found!"));
    }

    @Override
    public Car addCarWithVIN(String id, Car car) throws MyCarBadRequestException {
        String vin =  carDao.createWithVIN(id, car);

        return fetchCarById(vin);
    }
}
