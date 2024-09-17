package main.java.com.example.travel_agency.services;

import main.java.com.example.travel_agency.dao.CustomerRepository;
import main.java.com.example.travel_agency.dao.VacationRepository;
import main.java.com.example.travel_agency.entities.Customer;
import main.java.com.example.travel_agency.entities.Vacation;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private VacationRepository vacationRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               VacationRepository vacationRepository) {
        this.customerRepository = customerRepository;
        this.vacationRepository = vacationRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseData purchaseData) {
        // Retrieve the purchase info from dto
        Customer customer = purchaseData.getCustomer();

        // Save the customer
        customerRepository.save(customer);

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();

        // Save the vacations
        Set<Vacation> vacations = purchaseData.getVacations();
        vacations.forEach(vacation -> {
            vacationRepository.save(vacation);
        });

        // Return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // Generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
