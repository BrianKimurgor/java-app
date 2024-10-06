package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Repository;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, Integer> {
    
    // Method to find excursions by vacation ID
    List<Excursion> findByVacation_VacationId(Long vacationId);
}
