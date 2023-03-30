package com.mycar.mycarapi.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @GetMapping("")
    public ResponseEntity<List<People>> getAllPeople() {
        List<People> people = peopleService.fetchAllPeople();

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Optional<People>> addPeople(@RequestBody People people) {

        Optional<People> createdPeople = peopleService.addPeople(people);

        return new ResponseEntity<>(createdPeople, HttpStatus.CREATED);
    }
}
