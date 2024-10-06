package edu.wgu.d288_backend.controllers;

import edu.wgu.d288_backend.entities.Excursion;
import edu.wgu.d288_backend.services.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/vacations") // Change base URL to match the desired endpoint structure
public class ExcursionController {

    private final ExcursionService excursionService;

    @Autowired
    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @GetMapping("/{vacationId}/excursions") // Fetch excursions by vacation ID
    public List<Excursion> getExcursionsByVacationId(@PathVariable Long vacationId) {
        return excursionService.findByVacationId(vacationId);
    }

    // Other methods remain unchanged
    @GetMapping("/excursions")
    public List<Excursion> getAllExcursions() {
        return excursionService.getAllExcursions();
    }

    @GetMapping("/excursions/{id}")
    public Optional<Excursion> getExcursionById(@PathVariable Integer id) {
        return excursionService.getExcursionById(id);
    }

    @PostMapping("/excursions")
    public Excursion addExcursion(@RequestBody Excursion excursion) {
        return excursionService.addExcursion(excursion);
    }

    @PutMapping("/excursions/{id}")
    public Excursion updateExcursion(@PathVariable Integer id, @RequestBody Excursion excursionDetails) {
        return excursionService.updateExcursion(id, excursionDetails);
    }

    @DeleteMapping("/excursions/{id}")
    public void deleteExcursion(@PathVariable Integer id) {
        excursionService.deleteExcursion(id);
    }
}
