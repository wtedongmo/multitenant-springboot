package com.twb.controller;

import com.twb.entity.discriminator.City;
import com.twb.service.discriminator.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> getAll() throws SQLException {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> get(@PathVariable(value = "id") Long id) {
        City city = cityService.get(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<City> get(@PathVariable(value = "name") String name) {
        City city = cityService.getByName(name);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<City> delete(@PathVariable(value = "name") String name) {
        cityService.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
