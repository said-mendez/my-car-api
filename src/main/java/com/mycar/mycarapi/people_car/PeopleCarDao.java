package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.car.Car;
import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import com.mycar.mycarapi.people.People;

import java.util.List;

public interface PeopleCarDao {
    List<PeopleCar> getAllPeopleCars();
    List<Car> getAllPersonCars();
    List<People> getAllCarPeople();
    void create(PeopleCar peopleCar) throws MyCarBadRequestException;
    void update(String guid, String vin) throws MyCarResourceNotFoundException;
    void delete(String guid, String vin);
}
