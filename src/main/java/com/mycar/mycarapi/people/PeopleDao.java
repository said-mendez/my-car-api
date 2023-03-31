package com.mycar.mycarapi.people;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PeopleDao {
    List<People> getAll();
    String create(People people) throws MyCarBadRequestException;
    void update(String id, People people) throws MyCarBadRequestException;
    void delete(String id);
    Optional<People> getByGUID(String guid) throws MyCarResourceNotFoundException;
    String createWithGUID(String id, People people) throws MyCarBadRequestException;
}
