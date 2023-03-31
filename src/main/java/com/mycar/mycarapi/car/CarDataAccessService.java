package com.mycar.mycarapi.car;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarDataAccessService implements CarDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Car> getAll() {
        return jdbcTemplate.query(
                CarQueries.GET_ALL,
                new CarRowMapper()
        );
    }

    @Override
    public String create(Car car) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    CarQueries.INSERT,
                    car.vin().toUpperCase(),
                    car.brand().toUpperCase(),
                    car.model().toUpperCase(),
                    car.year(),
                    car.color().toUpperCase()
            );

            return car.vin().toUpperCase();
        } catch(Exception e) {
            throw new MyCarBadRequestException("Oops something went wrong!");
        }
    }

    @Override
    public void update(String id, Car car) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    CarQueries.UPDATE,
                    car.brand(),
                    car.model(),
                    car.year(),
                    car.color(),
                    id
            );
        } catch (Exception e) {
            throw new MyCarBadRequestException("Something went wrong! " +e);
        }
    }

    @Override
    public void delete(String id) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(CarQueries.DELETE, id);
        } catch (Exception e) {
            throw new MyCarBadRequestException("Oops something went wrong!");
        }
    }

    @Override
    public Optional<Car> getByVIN(String vin) throws MyCarResourceNotFoundException {
        try {
            return jdbcTemplate.query(CarQueries.GET_BY_VIN, new CarRowMapper(), vin)
                    .stream()
                    .findFirst()
                    ;
        } catch (Exception e){
            throw new MyCarResourceNotFoundException("Car not found!");
        }
    }

    @Override
    public String createWithVIN(String id, Car car) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    CarQueries.INSERT,
                    id.toUpperCase(),
                    car.brand().toUpperCase(),
                    car.model().toUpperCase(),
                    car.year(),
                    car.color().toUpperCase()
            );

            return id.toUpperCase();
        } catch(Exception e) {
            throw new MyCarBadRequestException("Oops something went wrong!");
        }
    }
}
