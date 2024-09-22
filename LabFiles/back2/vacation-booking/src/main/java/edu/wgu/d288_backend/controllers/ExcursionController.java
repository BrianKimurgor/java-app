package edu.wgu.d288_backend.controllers;


import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.services.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/excursions")
public class ExcursionController {

    private final ExcursionService excursionService;

    @Autowired
    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @GetMapping
    public List<Excursion> getAllExcursions() {
        return excursionService.getAllExcursions();
    }

    @GetMapping("/{id}")
    public Optional<Excursion> getExcursionById(@PathVariable Integer id) {
        return excursionService.getExcursionById(id);
    }

    @PostMapping
    public Excursion addExcursion(@RequestBody Excursion excursion) {
        return excursionService.addExcursion(excursion);
    }

    @PutMapping("/{id}")
    public Excursion updateExcursion(@PathVariable Integer id, @RequestBody Excursion excursionDetails) {
        return excursionService.updateExcursion(id, excursionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteExcursion(@PathVariable Integer id) {
        excursionService.deleteExcursion(id);
    }
}
