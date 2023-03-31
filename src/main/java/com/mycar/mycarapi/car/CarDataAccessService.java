package com.mycar.mycarapi.car;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarDataAccessService implements CarDao {
    private JdbcTemplate jdbcTemplate;

    public CarDataAccessService(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Car> getAll() {
        String sql = CarQueries.GET_ALL;

        return jdbcTemplate.query(sql, new CarRowMapper());
    }

    @Override
    public String create(Car car) throws MyCarBadRequestException {
        return null;
    }

    @Override
    public void update(String id, Car car) throws MyCarBadRequestException {

    }

    @Override
    public void delete(String id) throws MyCarResourceNotFoundException {

    }

    @Override
    public Optional<Car> getByVIN(String vin) throws MyCarResourceNotFoundException {
        return Optional.empty();
    }
}
