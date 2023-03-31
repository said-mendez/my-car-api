package com.mycar.mycarapi.people;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PeopleService {
    List<People> fetchAllPeople();
    People addPeople(People people) throws MyCarBadRequestException;
    void updatePeople(String id, People people) throws MyCarResourceNotFoundException;
    void deletePeople(String id) throws MyCarResourceNotFoundException;
    People fetchPeopleById(String id) throws MyCarResourceNotFoundException;
    People addPeopleWithGUID(String id, People people) throws MyCarBadRequestException;
}
