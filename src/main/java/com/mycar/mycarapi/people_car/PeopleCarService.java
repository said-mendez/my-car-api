package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.car.Car;
import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import com.mycar.mycarapi.people.People;

import java.util.List;

public interface PeopleCarService {
    List<PeopleCar> fetchAllPeopleCars();
    List<Car> fetchAllPersonCars(String guid);
    List<People> fetchAllCarPeople(String vin);
    void addPeopleCar(PeopleCar peopleCar) throws MyCarBadRequestException;
    void updatePeopleCar(String guid, String vin, PeopleCar peopleCar) throws MyCarBadRequestException;
    void deletePeopleCar(String guid, String vin) throws MyCarResourceNotFoundException;
}
