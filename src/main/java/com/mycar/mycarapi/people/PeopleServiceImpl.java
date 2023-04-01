package com.mycar.mycarapi.people;

import com.mycar.mycarapi.exceptions.MyCarBadRequestException;
import com.mycar.mycarapi.exceptions.MyCarResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class PeopleServiceImpl implements PeopleService {
    private PeopleDao peopleDao;

    public PeopleServiceImpl(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<People> fetchAllPeople() {
        return peopleDao.getAll();
    }

    @Override
    public People addPeople(People people) throws MyCarBadRequestException {
        String result = peopleDao.create(people);

        return fetchPeopleById(result);
    }

    @Transactional
    @Override
    public void updatePeople(String id, People people) throws MyCarResourceNotFoundException {

        fetchPeopleById(id);
        peopleDao.update(id, people);
    }

    @Transactional
    @Override
    public void deletePeople(String id) throws MyCarResourceNotFoundException {
        fetchPeopleById(id);
        peopleDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public People fetchPeopleById(String id) throws MyCarResourceNotFoundException {
        return peopleDao.getByGUID(id)
                .orElseThrow(() -> new MyCarResourceNotFoundException("Person not found!"))
                ;
    }

    @Transactional
    @Override
    public People addPeopleWithGUID(String id, People people) throws MyCarBadRequestException {
        String result = peopleDao.createWithGUID(id, people);

        return fetchPeopleById(result);
    }
}
