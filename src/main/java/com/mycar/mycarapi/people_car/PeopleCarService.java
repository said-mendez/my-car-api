package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.car.Car;
import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import com.mycar.mycarapi.people.People;

import java.util.List;

public interface PeopleCarService {
    List<Object> fetchAllCarsPeople();
    List<Car> fetchAllPersonCars();
    List<People> fetchAllCarPeople();
    PeopleCar addPeopleCar(String guid, String vin) throws MyCarBadRequestException;
    void updatePeopleCar(String guid, String vin) throws MyCarResourceNotFoundException;
    void deletePeopleCar(String guid, String vin) throws MyCarResourceNotFoundException;
    int countCarBelongsToNPeople(String vin);
}
