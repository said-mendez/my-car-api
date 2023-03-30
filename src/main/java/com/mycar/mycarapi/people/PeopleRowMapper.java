package com.mycar.mycarapi.people;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleRowMapper implements RowMapper<People> {
    @Override
    public People mapRow(ResultSet resultSet, int i) throws SQLException {
        return new People(
          resultSet.getString("guid"),
          resultSet.getString("firstname"),
          resultSet.getString("lastname"),
          resultSet.getString("email"),
          resultSet.getString("gender")
        );
    }
}
