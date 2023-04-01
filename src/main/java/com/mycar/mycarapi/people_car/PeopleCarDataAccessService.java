package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.car.Car;
import com.mycar.mycarapi.car.CarRowMapper;
import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.people.People;
import com.mycar.mycarapi.people.PeopleRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleCarDataAccessService implements PeopleCarDao {
    private final JdbcTemplate jdbcTemplate;

    public PeopleCarDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PeopleCar> getAllPeopleCars() {
        return jdbcTemplate.query(
                PeopleCarQueries.GET_ALL_PEOPLE_CARS,
                new PeopleCarRowMapper()
        );
    }

    @Override
    public List<Car> getAllPersonCars(String guid) {
        return jdbcTemplate.query(
                PeopleCarQueries.GET_ALL_PERSON_CARS,
                new CarRowMapper(),
                guid
        );
    }

    @Override
    public List<People> getAllCarPeople(String vin) {
        return jdbcTemplate.query(
          PeopleCarQueries.GET_ALL_CAR_PEOPLE,
          new PeopleRowMapper(),
          vin
        );
    }

    @Override
    public void create(PeopleCar peopleCar) throws MyCarBadRequestException {
        try {
            Integer currentCarAssignments = jdbcTemplate.queryForObject(
                    PeopleCarQueries.COUNT_CAR_BELONGS_TO_N_PEOPLE,
                    Integer.class,
                    peopleCar.carId()
            );

            if (currentCarAssignments >= 2) {
                throw new MyCarBadRequestException("Car is already assigned to two persons!");
            }

            jdbcTemplate.update(
                    PeopleCarQueries.INSERT,
                    peopleCar.peopleId(),
                    peopleCar.carId()
            );
        } catch (Exception e) {
            throw new MyCarBadRequestException("Something went wrong! " + e);
        }
    }

    @Override
    public void update(String guid, String vin, PeopleCar peopleCar) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    PeopleCarQueries.UPDATE,
                    peopleCar.peopleId(),
                    peopleCar.carId(),
                    vin,
                    guid
            );
        } catch (Exception e) {
            throw new MyCarBadRequestException("Oop something went wrong updating you car people relation!");
        }
    }

    @Override
    public void delete(String guid, String vin) {

    }
}
