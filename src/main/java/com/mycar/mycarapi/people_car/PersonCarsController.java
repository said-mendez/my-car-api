package com.mycar.mycarapi.people_car;

import com.mycar.mycarapi.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people/{guid}/cars")
public class PersonCarsController {
    @Autowired
    PeopleCarService peopleCarService;

    @GetMapping("")
    public ResponseEntity<List<Car>> getPersonCars(@PathVariable("guid") String guid) {
        List<Car> personCars = peopleCarService.fetchAllPersonCars(guid);

        return new ResponseEntity<>(personCars, HttpStatus.OK);
    }
}
