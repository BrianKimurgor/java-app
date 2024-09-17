package com.example.demo.dao;

import com.example.demo.entities.VacationPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface VacationPackageRepository extends JpaRepository<VacationPackage, Long> {
}
