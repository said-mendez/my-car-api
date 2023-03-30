package com.mycar.mycarapi.people;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PeopleDao {
    List<People> getAll();
    String create(People people) throws MyCarBadRequestException;
    int update(int id, People people) throws MyCarBadRequestException;
    int delete(int id) throws MyCarResourceNotFoundException;
    Optional<People> getByGUID(String guid) throws MyCarResourceNotFoundException;
}
