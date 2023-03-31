package com.mycar.mycarapi.people_car;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleCarRowMapper implements RowMapper<PeopleCar> {
    @Override
    public PeopleCar mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new PeopleCar(
                resultSet.getString("peopleid"),
                resultSet.getString("carid")
        );
    }
}
