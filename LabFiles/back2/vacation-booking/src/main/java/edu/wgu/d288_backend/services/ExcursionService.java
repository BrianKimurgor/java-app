package edu.wgu.d288_backend.services;

import edu.wgu.d288_backend.dao.ExcursionRepository;
import edu.wgu.d288_backend.entities.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcursionService {

    private final ExcursionRepository excursionRepository;

    @Autowired
    public ExcursionService(ExcursionRepository excursionRepository) {
        this.excursionRepository = excursionRepository;
    }

    public List<Excursion> getAllExcursions() {
        return excursionRepository.findAll();
    }

    public Optional<Excursion> getExcursionById(Integer id) {
        return excursionRepository.findById(id);
    }

    public Excursion addExcursion(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    public Excursion updateExcursion(Integer id, Excursion excursionDetails) {
        return excursionRepository.findById(id).map(excursion -> {
            excursion.setExcursionTitle(excursionDetails.getExcursionTitle());
            excursion.setExcursionPrice(excursionDetails.getExcursionPrice());
            excursion.setImageUrl(excursionDetails.getImageUrl());
            excursion.setCreateDate(excursionDetails.getCreateDate());
            excursion.setLastUpdate(excursionDetails.getLastUpdate());
            excursion.setVacation(excursionDetails.getVacation());
            return excursionRepository.save(excursion);
        }).orElseThrow(() -> new RuntimeException("Excursion not found with id " + id));
    }

    public void deleteExcursion(Integer id) {
        excursionRepository.deleteById(id);
    }
}
