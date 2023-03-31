package com.mycar.mycarapi.car;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Car (
                resultSet.getString("vin"),
                resultSet.getString("brand"),
                resultSet.getString("model"),
                resultSet.getInt("year"),
                resultSet.getString("color")
        );
    }
}
