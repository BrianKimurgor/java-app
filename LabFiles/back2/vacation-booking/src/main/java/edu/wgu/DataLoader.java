package edu.wgu;

import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadSampleData(CustomerRepository customerRepository) {
        return args -> {
            // Add sample customers
            Customer customer1 = new Customer();
            customer1.setCustomerFirstName("John");
            customer1.setCustomerLastName("Doe");
            customer1.setAddress("123 Main St");
            customer1.setPhone("Chicago");
            customer1.setPostalCode("10001");
            customer1.setState("NY");
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setCustomerFirstName("Jane");
            customer2.setCustomerLastName("Doe");
            customer2.setAddress("456 Elm St");
            customer2.setPhone("Chicago");
            customer2.setPostalCode("60605");
            customerRepository.save(customer2);

            // Add more customers as needed
        };
    }
}
