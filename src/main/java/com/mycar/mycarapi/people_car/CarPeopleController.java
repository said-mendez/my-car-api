package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.people.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars/{vin}/people")
public class CarPeopleController {
    @Autowired
    PeopleCarService peopleCarService;

    @GetMapping("")
    public ResponseEntity<List<People>> getCarPeople(@PathVariable("vin") String vin) {
        List<People> peopleList = peopleCarService.fetchAllCarPeople(vin);

        return new ResponseEntity<>(peopleList, HttpStatus.OK);
    }
}
