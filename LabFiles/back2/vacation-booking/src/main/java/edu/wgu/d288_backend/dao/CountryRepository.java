package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Repository;

@CrossOrigin("http://localhost:4200")
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
