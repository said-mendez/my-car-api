package com.mycar.mycarapi.people;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PeopleDataAccessService implements PeopleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<People> getAll() {
        String sql = PeopleQueries.GET_ALL;

        return jdbcTemplate.query(sql, new PeopleRowMapper());
    }

    @Override
    public String create(People people) throws MyCarBadRequestException {
        UUID uui = UUID.randomUUID();
        String uuiString = uui.toString();

        try {
            jdbcTemplate.update(
                    PeopleQueries.INSERT,
                    uuiString,
                    people.firstName(),
                    people.lastName(),
                    people.email().toLowerCase(),
                    people.gender().toLowerCase()
            );

            return uuiString;
        } catch(Exception e) {
            throw new MyCarBadRequestException("Invalid Request");
        }

    }

    @Override
    public void update(String id, People people) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    PeopleQueries.UPDATE,
                    people.firstName(),
                    people.lastName(),
                    people.email().toLowerCase(),
                    people.gender().toLowerCase(),
                    id
            );
        } catch(Exception e) {
            throw new MyCarBadRequestException("Oops something went wrong!");
        }
    }

    @Override
    public void delete(String id) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    PeopleQueries.DELETE,
                    id
            );
        } catch (Exception e) {
            throw new MyCarBadRequestException("Oop something went wrong!");
        }
    }

    @Override
    public Optional<People> getByGUID(String guid) throws MyCarResourceNotFoundException {
        try {
            return jdbcTemplate.query(PeopleQueries.GET_BY_GUID, new PeopleRowMapper(), guid)
                    .stream()
                    .findFirst()
                    ;
        } catch(Exception e) {
            throw new MyCarResourceNotFoundException("People not found!");
        }

    }

    @Override
    public String createWithGUID(String id, People people) throws MyCarBadRequestException {
        try {
            jdbcTemplate.update(
                    PeopleQueries.INSERT,
                    id,
                    people.firstName(),
                    people.lastName(),
                    people.email().toLowerCase(),
                    people.gender().toLowerCase()
            );

            return id;
        } catch(Exception e) {
            throw new MyCarBadRequestException("Invalid Request");
        }
    }
}
