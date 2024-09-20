package edu.wgu.d288_backend.dao;

import edu.wgu.d288_backend.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Repository;

@CrossOrigin("http://localhost:4200")
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
