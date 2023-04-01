package com.mycar.mycarapi.people_car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public  ResponseEntity<PeopleCar> addPeople(@RequestBody PeopleCar peopleCar) {
        peopleCarService.addPeopleCar(peopleCar);

        return new ResponseEntity<>(peopleCar, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}/{vin}")
    public ResponseEntity<Map<String, Boolean>> updatePeopleCar(@PathVariable("guid") String guid, @PathVariable("vin") String vin, @RequestBody PeopleCar peopleCar) {
        peopleCarService.updatePeopleCar(guid, vin, peopleCar);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
