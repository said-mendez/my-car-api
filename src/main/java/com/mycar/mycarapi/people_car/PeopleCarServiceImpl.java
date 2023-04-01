package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.car.Car;
import com.mycar.mycarapi.car.CarDao;
import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import com.mycar.mycarapi.people.People;
import com.mycar.mycarapi.people.PeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PeopleCarServiceImpl implements PeopleCarService {
    @Autowired
    PeopleCarDao peopleCarDao;

    @Override
    public List<PeopleCar> fetchAllPeopleCars() {
        return peopleCarDao.getAllPeopleCars();
    }

    @Override
    public List<Car> fetchAllPersonCars(String guid) {
        return peopleCarDao.getAllPersonCars(guid);
    }

    @Override
    public List<People> fetchAllCarPeople(String vin) {
        return peopleCarDao.getAllCarPeople(vin);
    }

    @Override
    public void addPeopleCar(PeopleCar peopleCar) throws MyCarBadRequestException {
        peopleCarDao.create(peopleCar);
    }

    @Override
    public void updatePeopleCar(String guid, String vin, PeopleCar peopleCar) throws MyCarBadRequestException {
        // TODO: Check if a record exists with the given vin, gui
        peopleCarDao.update(guid, vin, peopleCar);
    }

    @Override
    public void deletePeopleCar(String guid, String vin) throws MyCarResourceNotFoundException {

    }
}
