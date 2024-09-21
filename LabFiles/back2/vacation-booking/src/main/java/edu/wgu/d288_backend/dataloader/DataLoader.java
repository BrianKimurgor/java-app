package edu.wgu.d288_backend.dataloader;

import edu.wgu.d288_backend.entities.Customer;
import edu.wgu.d288_backend.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
    }

    private void loadCustomers() {
        // Sample data
        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setAddress("123 Main St");
        customer1.setPostalCode("12345");
        customer1.setPhone("555-1234");
        customer1.setCreateDate(LocalDateTime.now());
        customer1.setLastUpdate(LocalDateTime.now());
        customer1.setDivisionId(1L); // Assuming a valid division_id

        Customer customer2 = new Customer();
        customer2.setFirstName("Jane");
        customer2.setLastName("Smith");
        customer2.setAddress("456 Elm St");
        customer2.setPostalCode("67890");
        customer2.setPhone("555-5678");
        customer2.setCreateDate(LocalDateTime.now());
        customer2.setLastUpdate(LocalDateTime.now());
        customer2.setDivisionId(1L); // Assuming a valid division_id

        // Save to the repository
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        System.out.println("Loaded customers data");
    }
}
