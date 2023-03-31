package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.people.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people/cars")
public class PeopleCarController {
    @Autowired
    PeopleCarService peopleCarService;

    @GetMapping("")
    public ResponseEntity<List<PeopleCar>> getAllPeopleCars() {
        List<PeopleCar> peopleCars = peopleCarService.fetchAllPeopleCars();

        return new ResponseEntity<>(peopleCars, HttpStatus.OK);
    }

    @PostMapping("")
    public  ResponseEntity<PeopleCar> addPeopleController(@RequestBody PeopleCar peopleCar) {
        peopleCarService.addPeopleCar(peopleCar);

        return new ResponseEntity<>(peopleCar, HttpStatus.CREATED);
    }
}
