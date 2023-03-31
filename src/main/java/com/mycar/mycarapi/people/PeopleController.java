package com.mycar.mycarapi.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/{guid}")
    public People getPeopleByGUID(@PathVariable("guid") String guid) {
        return peopleService.fetchPeopleById(guid);
    }

    @PostMapping("")
    public ResponseEntity<Optional<People>> addPeople(@RequestBody People people) {

        Optional<People> createdPeople = peopleService.addPeople(people);

        return new ResponseEntity<>(createdPeople, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<Map<String, Boolean>> updatePeople(@PathVariable("guid") String guid, @RequestBody People people) {
        peopleService.updatePeople(guid, people);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("{guid}")
    public ResponseEntity<Map<String, Boolean>> deletePeople(@PathVariable("guid") String guid) {
        peopleService.deletePeople(guid);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
