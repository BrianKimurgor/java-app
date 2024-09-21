package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional query methods can be defined here
}
