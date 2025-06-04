package com.adaclean.backend.controller;
import com.adaclean.backend.tables.Gathering;
import com.adaclean.backend.repository.GatheringRepository;
import com.adaclean.backend.tables.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gathering")
@CrossOrigin(origins = "*")
public class GatheringController {
    @Autowired

    private GatheringRepository GatheringRepository;
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Gathering> getName() {
        // This returns a JSON or XML with the cities
        return GatheringRepository.findAll();
    }

    @PostMapping
    public Gathering createGathering(@RequestBody Gathering gathering) {
        return GatheringRepository.save(gathering);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id ) {
        GatheringRepository.deleteById(id);
    }



}
