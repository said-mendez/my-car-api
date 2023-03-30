package com.mycar.mycarapi.people;

import java.util.List;
import java.util.Optional;

public interface PeopleService {
    List<People> fetchAllPeople();
    Optional<People> addPeople(People people);
    void updatePeople(int id, People people);
    void deletePeople(int id);
    Optional<People> fetchPeopleById(int id);
}
