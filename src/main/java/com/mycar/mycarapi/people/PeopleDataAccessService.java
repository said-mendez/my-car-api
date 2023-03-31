package com.mycar.mycarapi.people;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PeopleDataAccessService implements PeopleDao {
    private final JdbcTemplate jdbcTemplate;

    public PeopleDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<People> getAll() {
        String sql = PeopleQueries.GET_ALL;

        return jdbcTemplate.query(sql, new PeopleRowMapper());
    }

    @Override
    public String create(People people) throws MyCarBadRequestException {
        String sql = PeopleQueries.INSERT;
        UUID uui = UUID.randomUUID();
        String uuiString = uui.toString();

        try {
            jdbcTemplate.update(
                    sql,
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
        String sql = PeopleQueries.UPDATE;

        try {
            jdbcTemplate.update(
                    sql,
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
    public void delete(String id) {
        String sql = PeopleQueries.DELETE;

        jdbcTemplate.update(
                sql,
                id
        );
    }

    @Override
    public Optional<People> getByGUID(String guid) throws MyCarResourceNotFoundException {
        String sql = PeopleQueries.GET_BY_GUID;

        try {
            return jdbcTemplate.query(sql, new PeopleRowMapper(), guid)
                    .stream()
                    .findFirst()
                    ;
        } catch(Exception e) {
            throw new MyCarResourceNotFoundException("People not found!");
        }

    }
}
