package main.java.com.example.travel_agency.config;

import main.java.com.example.travel_agency.dao.CustomerRepository;
import main.java.com.example.travel_agency.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Customer("John", "Doe", "john@example.com"));
                repository.save(new Customer("Jane", "Smith", "jane@example.com"));
                repository.save(new Customer("Mike", "Johnson", "mike@example.com"));
                repository.save(new Customer("Emily", "Brown", "emily@example.com"));
                repository.save(new Customer("David", "Wilson", "david@example.com"));
            }
        };
    }
}
