package com.adaclean.backend.controller;
import com.adaclean.backend.tables.City;
import com.adaclean.backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins = "*")
public class CityController {
    @Autowired

    private CityRepository CityRepository;
    @GetMapping(path="/all")
    public @ResponseBody Iterable<City> getName() {
        return CityRepository.findAll();
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return CityRepository.save(city);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id ) {
        CityRepository.deleteById(id);
    }
}


