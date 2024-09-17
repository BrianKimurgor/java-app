package main.java.com.example.travel_agency.services;

import main.java.com.example.travel_agency.entities.Customer;
import main.java.com.example.travel_agency.entities.Vacation;
import lombok.Data;

import java.util.Set;

@Data
public class PurchaseData {
    private Customer customer;
    private Set<Vacation> vacations;
}
