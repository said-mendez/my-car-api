package com.mycar.mycarapi.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleDao peopleDao;

    @Override
    public List<People> fetchAllPeople() {
        return peopleDao.getAll();
    }

    @Override
    public Optional<People> addPeople(People people) {
        String result = peopleDao.create(people);

        return peopleDao.getByGUID(result);
    }

    @Override
    public void updatePeople(int id, People people) {

    }

    @Override
    public void deletePeople(int id) {

    }

    @Override
    public Optional<People> fetchPeopleById(int id) {
        return Optional.empty();
    }
}
