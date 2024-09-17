package com.example.demo.services;

import com.example.demo.dao.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Generate tracking number
        String orderTrackingNumber = UUID.randomUUID().toString();

        // Persist customer
        purchase.getCustomer().getVacationPackages().forEach(pkg -> pkg.setCustomer(purchase.getCustomer()));
        customerRepository.save(purchase.getCustomer());

        // Return response with tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }
}
